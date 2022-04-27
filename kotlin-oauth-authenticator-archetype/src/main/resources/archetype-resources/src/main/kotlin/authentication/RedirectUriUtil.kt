package ${package}.authentication

import se.curity.identityserver.sdk.errors.ErrorCode
import se.curity.identityserver.sdk.service.ExceptionFactory
import se.curity.identityserver.sdk.service.authentication.AuthenticatorInformationProvider

import java.net.MalformedURLException
import java.net.URI
import java.net.URL

import ${package}.descriptor.${pluginName}AuthenticatorPluginDescriptor.Companion.CALLBACK

final class RedirectUriUtil()
{

    companion object {
        public fun createRedirectUri(authenticatorInformationProvider: AuthenticatorInformationProvider,
        exceptionFactory: ExceptionFactory): String
        {
            try
            {
                val authUri = authenticatorInformationProvider.getFullyQualifiedAuthenticationUri()

                return URL(authUri.toURL(), authUri.getPath() + "/" + CALLBACK).toString()
            }
            catch (e: MalformedURLException)
            {
                throw exceptionFactory.internalServerException(ErrorCode.INVALID_REDIRECT_URI,
                    "Could not create redirect URI")
            }
        }
    }
}
