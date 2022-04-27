package ${package}.authentication

import ${package}.config.${pluginName}AuthenticatorPluginConfig
import ${package}.authentication.RedirectUriUtil.Companion.createRedirectUri
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import se.curity.identityserver.sdk.attribute.Attribute
import se.curity.identityserver.sdk.authentication.AuthenticationResult
import se.curity.identityserver.sdk.authentication.AuthenticatorRequestHandler
import se.curity.identityserver.sdk.errors.ErrorCode
import se.curity.identityserver.sdk.http.RedirectStatusCode
import se.curity.identityserver.sdk.service.ExceptionFactory
import se.curity.identityserver.sdk.service.authentication.AuthenticatorInformationProvider
import se.curity.identityserver.sdk.web.Request
import se.curity.identityserver.sdk.web.Response

import java.net.MalformedURLException
import java.net.URL
import java.util.Optional
import java.util.UUID

class ${pluginName}AuthenticatorRequestHandler(private val _config: ${pluginName}AuthenticatorPluginConfig): AuthenticatorRequestHandler<Request>
{
    private val _authenticatorInformationProvider: AuthenticatorInformationProvider = _config.getAuthenticatorInformationProvider()
    private val _exceptionFactory: ExceptionFactory = _config.getExceptionFactory()

    override fun get(request: Request, response: Response): Optional<AuthenticationResult>
    {
        _logger.debug("GET request received for authentication")

        val redirectUri = createRedirectUri(_authenticatorInformationProvider, _exceptionFactory)
        val state = UUID.randomUUID().toString()
        val scopes = setOf("scope")

        _config.getSessionManager().put(Attribute.of("state", state))

        val queryStringArguments = linkedMapOf<String, Collection<String>>(
                "client_id" to setOf(_config.getClientId()),
                "redirect_uri" to setOf(redirectUri),
                "state" to setOf(state),
                "response_type" to setOf("code"),
                "scope" to setOf(scopes.joinToString(" "))
        )

        _logger.debug("Redirecting to {} with query string arguments {}", AUTHORIZATION_ENDPOINT,
                queryStringArguments)

        throw _exceptionFactory.redirectException(AUTHORIZATION_ENDPOINT,
                RedirectStatusCode.MOVED_TEMPORARILY, queryStringArguments, false)
    }

    override fun post(request: Request, response: Response): Optional<AuthenticationResult>
    {
        throw _exceptionFactory.methodNotAllowed()
    }

    override fun preProcess(request: Request, response: Response): Request
    {
        return request
    }

    companion object
    {
        private val _logger: Logger = LoggerFactory.getLogger(${pluginName}AuthenticatorRequestHandler::class.java)
        private const val AUTHORIZATION_ENDPOINT = ""

    }
}
