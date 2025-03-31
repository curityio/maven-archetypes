package ${package}.authentication

import ${package}.config.${pluginName}AuthenticatorPluginConfig
import ${package}.authentication.RedirectUriUtil.Companion.createRedirectUri
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import se.curity.identityserver.sdk.attribute.Attribute
import se.curity.identityserver.sdk.attribute.Attributes
import se.curity.identityserver.sdk.attribute.AuthenticationAttributes
import se.curity.identityserver.sdk.attribute.ContextAttributes
import se.curity.identityserver.sdk.attribute.SubjectAttributes
import se.curity.identityserver.sdk.authentication.AuthenticationResult
import se.curity.identityserver.sdk.authentication.AuthenticatorRequestHandler
import se.curity.identityserver.sdk.errors.ErrorCode
import se.curity.identityserver.sdk.http.HttpRequest
import se.curity.identityserver.sdk.http.HttpResponse
import se.curity.identityserver.sdk.service.ExceptionFactory
import se.curity.identityserver.sdk.service.Json
import se.curity.identityserver.sdk.service.WebServiceClient
import se.curity.identityserver.sdk.service.WebServiceClientFactory
import se.curity.identityserver.sdk.service.authentication.AuthenticatorInformationProvider
import se.curity.identityserver.sdk.web.Request
import se.curity.identityserver.sdk.web.Response

import java.io.UnsupportedEncodingException
import java.net.URI
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.Objects
import java.util.Optional

class CallbackRequestHandler(private val _config: ${pluginName}AuthenticatorPluginConfig): AuthenticatorRequestHandler<CallbackRequestModel>
{
    private val _exceptionFactory: ExceptionFactory = _config.getExceptionFactory()
    private val _json: Json = _config.getJson()
    private val _authenticatorInformationProvider: AuthenticatorInformationProvider = _config.getAuthenticatorInformationProvider()
    private val _webServiceClientFactory: WebServiceClientFactory = _config.getWebServiceClientFactory()

    override fun preProcess(request: Request, response: Response): CallbackRequestModel
    {
        if (request.isGetRequest)
        {
            return CallbackRequestModel(request)
        }
        else
        {
            throw _exceptionFactory.methodNotAllowed()
        }
    }

    override fun post(requestModel: CallbackRequestModel, response: Response): Optional<AuthenticationResult>
    {
        throw _exceptionFactory.methodNotAllowed()
    }

    override fun get(requestModel: CallbackRequestModel, response: Response): Optional<AuthenticationResult>
    {
        validateState(requestModel.state)
        handleError(requestModel)

        val tokenResponseData = redeemCodeForTokens(requestModel)

        val subjectAttributes = listOf(Attribute.of("id", Objects.toString(tokenResponseData["id"])))

        val attributes = AuthenticationAttributes.of(
                SubjectAttributes.of(tokenResponseData["id"].toString(), Attributes.of(subjectAttributes)),
                ContextAttributes.of(Attributes.of(Attribute.of("access_token", tokenResponseData["access_token"].toString()))))
        val authenticationResult = AuthenticationResult(attributes)
        return Optional.of(authenticationResult)
    }

    private fun redeemCodeForTokens(requestModel: CallbackRequestModel): Map<String, Any>
    {
        val redirectUri = createRedirectUri(_authenticatorInformationProvider, _exceptionFactory)

        val tokenResponse = getWebServiceClient()
                .withPath("/oauth/v2/accessToken")
                .request()
                .contentType("application/x-www-form-urlencoded")
                .body(getFormEncodedBodyFrom(createPostData(_config.getClientId(), _config.getClientSecret(),
                        requestModel.code, redirectUri)))
                .method("POST")
                .response()
        val statusCode = tokenResponse.statusCode()

        if (statusCode != 200)
        {
            if (_logger.isInfoEnabled)
            {
                _logger.info("Got error response from token endpoint: error = {}, {}", statusCode,
                        tokenResponse.body(HttpResponse.asString()))
            }

            throw _exceptionFactory.internalServerException(ErrorCode.EXTERNAL_SERVICE_ERROR)
        }

        return _json.fromJson(tokenResponse.body(HttpResponse.asString()))
    }

    private fun getWebServiceClient(): WebServiceClient
    {
        val httpClient = _config.getHttpClient()

        return if (httpClient.isPresent)
        {
            _webServiceClientFactory.create(httpClient.get()).withHost("host.server.com")
        } else
        {
            _webServiceClientFactory.create(URI.create("https://host.server.com"))
        }
    }

    private fun handleError(requestModel: CallbackRequestModel)
    {
        if (requestModel.error != null)
        {
            if ("access_denied" == requestModel.error)
            {
                _logger.debug("Got an error from ${pluginName}: {} - {}", requestModel.error, requestModel.errorDescription)

                throw _exceptionFactory.redirectException(
                        _authenticatorInformationProvider.authenticationBaseUri.toASCIIString())
            }

            _logger.warn("Got an error from ${pluginName}: {} - {}", requestModel.error, requestModel.errorDescription)

            throw _exceptionFactory.externalServiceException("Login with ${pluginName} failed")
        }
    }

    private fun createPostData(clientId: String, clientSecret: String, code: String, callbackUri: String): Map<String, String> = hashMapOf(
        "client_id" to clientId,
        "client_secret" to clientSecret,
        "code" to code,
        "grant_type" to "authorization_code",
        "redirect_uri" to callbackUri
    )

    private fun getFormEncodedBodyFrom(data: Map<String, String>): HttpRequest.BodyProcessor
    {
        val stringBuilder = StringBuilder()

        data.entries.forEach { e -> stringBuilder.appendParameter(e) }

        return HttpRequest.fromString(stringBuilder.toString(), StandardCharsets.UTF_8)
    }

    private fun StringBuilder.appendParameter(entry: Map.Entry<String, String>)
    {
        val key = entry.key
        val value = entry.value
        append(urlEncodeString(key))
        append("=").append(urlEncodeString(value))
        append("&")
    }

    private fun urlEncodeString(unencodedString: String): String
    {
        try
        {
            return URLEncoder.encode(unencodedString, StandardCharsets.UTF_8.name())
        }
        catch (e: UnsupportedEncodingException)
        {
            throw RuntimeException("This server cannot support UTF-8!", e)
        }
    }

    private fun validateState(state: String)
    {
        val sessionAttribute: Attribute? = _config.getSessionManager().get("state")

        if (state == sessionAttribute?.getValueOfType(String::class.java))
        {
            _logger.debug("State matches session")
        }
        else
        {
            _logger.debug("State did not match session")

            throw _exceptionFactory.badRequestException(ErrorCode.INVALID_SERVER_STATE, "Bad state provided")
        }
    }

    companion object
    {
        private val _logger: Logger = LoggerFactory.getLogger(CallbackRequestHandler::class.java)
    }
}
