package ${package}.${pluginName}

import se.curity.identityserver.sdk.attribute.AuthenticationAttributes
import se.curity.identityserver.sdk.authentication.AuthenticatedSessions
import se.curity.identityserver.sdk.authenticationaction.AuthenticationAction
import se.curity.identityserver.sdk.authenticationaction.AuthenticationActionResult
import se.curity.identityserver.sdk.service.authenticationaction.AuthenticatorDescriptor

class ${pluginName}AuthenticationAction(private val _configuration: ${pluginName}AuthenticationActionConfig): AuthenticationAction
{
    override fun apply(authenticationAttributes: AuthenticationAttributes,
                                            authenticatedSessions: AuthenticatedSessions,
                                            authenticationTransactionId: String,
                                            authenticatorDescriptor: AuthenticatorDescriptor): AuthenticationActionResult
    {

        // Have a look at this example: https://github.com/curityio/time-authentication-action
        // to see what you can do in a plugin. If you prefer going straight to the docs, here's a link:
        // https://developer.curity.io/docs/latest/developer-guide/plugins/index.html

        return AuthenticationActionResult.successfulResult(authenticationAttributes)
    }
}
