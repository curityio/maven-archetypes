package ${package}.authentication

import se.curity.identityserver.sdk.errors.ErrorCode.INVALID_REDIRECT_URI
import se.curity.identityserver.sdk.service.ExceptionFactory
import se.curity.identityserver.sdk.service.authentication.AuthenticatorInformationProvider

import java.net.MalformedURLException
import java.net.URL

import ${package}.descriptor.${pluginName}AuthenticatorPluginDescriptor.Companion.CALLBACK

class RedirectUriUtil
{
    private constructor()

    companion object {
        fun createRedirectUri(authenticatorInformationProvider: AuthenticatorInformationProvider,
        exceptionFactory: ExceptionFactory): String
        {
            try
            {
                val authUri = authenticatorInformationProvider.fullyQualifiedAuthenticationUri

                return URL(authUri.toURL(), authUri.path + "/" + CALLBACK).toString()
            }
            catch (e: MalformedURLException)
            {
                throw exceptionFactory.internalServerException(ErrorCode.INVALID_REDIRECT_URI,
                    "Could not create redirect URI")
            }
        }
    }
}
