package ${package}.authentication

import se.curity.identityserver.sdk.errors.ErrorCode.INVALID_REDIRECT_URI
import se.curity.identityserver.sdk.service.ExceptionFactory
import se.curity.identityserver.sdk.service.authentication.AuthenticatorInformationProvider

import java.net.MalformedURLException
import java.net.URI
import java.net.URISyntaxException

import ${package}.descriptor.${pluginName}AuthenticatorPluginDescriptor.Companion.CALLBACK
class RedirectUriUtil
{
    companion object {
        fun createRedirectUri(authenticatorInformationProvider: AuthenticatorInformationProvider,
                              exceptionFactory: ExceptionFactory): String
        {
            try
            {
                val authUri = authenticatorInformationProvider.fullyQualifiedAuthenticationUri

                return URI(authUri.scheme, authUri.authority, authUri.path + "/" + CALLBACK, authUri.query, authUri.fragment).toURL().toString()
            }
            catch (e: MalformedURLException)
            {
                throw exceptionFactory.internalServerException(INVALID_REDIRECT_URI,
                    "Could not create redirect URI")
            }
            catch (e: URISyntaxException)
            {
                throw exceptionFactory.internalServerException(INVALID_REDIRECT_URI,
                    "Could not create redirect URI")

            }
        }
    }
}
