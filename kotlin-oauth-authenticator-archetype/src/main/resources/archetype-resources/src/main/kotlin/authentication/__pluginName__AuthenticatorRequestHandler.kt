package ${package}.authentication

import ${package}.config.${pluginName}AuthenticatorPluginConfig
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

import ${package}.descriptor.${pluginName}AuthenticatorPluginDescriptor.Companion.CALLBACK

class ${pluginName}AuthenticatorRequestHandler(private val _config: ${pluginName}AuthenticatorPluginConfig): AuthenticatorRequestHandler<Request>
{
    private val _authenticatorInformationProvider: AuthenticatorInformationProvider = _config.getAuthenticatorInformationProvider()
    private val _exceptionFactory: ExceptionFactory = _config.getExceptionFactory()

    override fun get(request: Request, response: Response): Optional<AuthenticationResult>
    {
        _logger.debug("GET request received for authentication")

        val redirectUri = createRedirectUri()
        val state = UUID.randomUUID().toString()
        val scopes = setOf("scope")

        _config.getSessionManager().put(Attribute.of("state", state))

        val queryStringArguments = linkedMapOf<String, Collection<String>>(
                Pair("client_id", setOf(_config.getClientId())),
                Pair("redirect_uri", setOf(redirectUri)),
                Pair("state", setOf(state)),
                Pair("response_type", setOf("code")),
                Pair("scope", setOf(scopes.joinToString(" ")))
        )

        _logger.debug("Redirecting to {} with query string arguments {}", AUTHORIZATION_ENDPOINT,
                queryStringArguments)

        throw _exceptionFactory.redirectException(AUTHORIZATION_ENDPOINT,
                RedirectStatusCode.MOVED_TEMPORARILY, queryStringArguments, false)
    }

    private fun createRedirectUri(): String
    {
        try
        {
            val authUri = _authenticatorInformationProvider.fullyQualifiedAuthenticationUri

            return URL(authUri.toURL(), authUri.path + "/" + CALLBACK).toString()
        }
        catch (e: MalformedURLException)
        {
            throw _exceptionFactory.internalServerException(ErrorCode.INVALID_REDIRECT_URI,
                    "Could not create redirect URI")
        }
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
