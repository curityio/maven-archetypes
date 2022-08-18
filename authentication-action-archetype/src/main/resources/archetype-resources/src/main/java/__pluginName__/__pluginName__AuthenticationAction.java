package ${package}.${pluginName};

import se.curity.identityserver.sdk.attribute.AuthenticationAttributes;
import se.curity.identityserver.sdk.authentication.AuthenticatedSessions;
import se.curity.identityserver.sdk.authenticationaction.AuthenticationAction;
import se.curity.identityserver.sdk.authenticationaction.AuthenticationActionResult;
import se.curity.identityserver.sdk.service.authenticationaction.AuthenticatorDescriptor;

public final class ${pluginName}AuthenticationAction implements AuthenticationAction
{
    private final ${pluginName}AuthenticationActionConfig _configuration;

    public ${pluginName}AuthenticationAction(${pluginName}AuthenticationActionConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public AuthenticationActionResult apply(AuthenticationActionContext context)
    {

        // Have a look at this example: https://github.com/curityio/time-authentication-action
        // to see what you can do in a plugin. If you prefer going straight to the docs, here's a link:
        // https://curity.io/docs/idsvr/latest/developer-guide/plugins/index.html

        return AuthenticationActionResult.successfulResult(context.getAuthenticationAttributes());
    }
}
