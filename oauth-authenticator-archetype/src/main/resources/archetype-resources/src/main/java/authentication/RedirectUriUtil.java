package ${package}.authentication;

import se.curity.identityserver.sdk.errors.ErrorCode;
import se.curity.identityserver.sdk.service.ExceptionFactory;
import se.curity.identityserver.sdk.service.authentication.AuthenticatorInformationProvider;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static ${package}.descriptor.${pluginName}AuthenticatorPluginDescriptor.CALLBACK;

final class RedirectUriUtil
{
    private RedirectUriUtil() { }

    static String createRedirectUri(AuthenticatorInformationProvider authenticatorInformationProvider,
                                    ExceptionFactory exceptionFactory)
    {
        try
        {
            URI authUri = authenticatorInformationProvider.getFullyQualifiedAuthenticationUri();

            return new URI(
                    authUri.getScheme(),
                    authUri.getAuthority(),
                    authUri.getPath() + "/" + CALLBACK,
                    authUri.getQuery(),
                    authUri.getFragment()
            ).toURL().toString();
        }
        catch (URISyntaxException | MalformedURLException e)
        {
            throw exceptionFactory.internalServerException(ErrorCode.INVALID_REDIRECT_URI,
                    "Could not create redirect URI");
        }
    }
}
