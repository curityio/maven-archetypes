package ${package}.${pluginName};

import se.curity.identityserver.sdk.attribute.ContextAttributes;
import se.curity.identityserver.sdk.attribute.SubjectAttributes;
import se.curity.identityserver.sdk.authorization.AuthorizationResult;
import se.curity.identityserver.sdk.authorization.OAuthObligation;
import se.curity.identityserver.sdk.authorization.oauth.OAuthAuthorizationActionAttributes;
import se.curity.identityserver.sdk.authorization.oauth.OAuthAuthorizationManager;
import se.curity.identityserver.sdk.authorization.oauth.OAuthAuthorizationResourceAttributes;

public final class ${pluginName}OAuthAuthorizationManager implements OAuthAuthorizationManager
{
    private final ${pluginName}AuthorizationManagerConfig _configuration;

    public ${pluginName}OAuthAuthorizationManager(${pluginName}AuthorizationManagerConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public AuthorizationResult<OAuthObligation> getOAuthAuthorizationResult(SubjectAttributes subjectAttributes,
                                                                            OAuthAuthorizationActionAttributes oAuthAuthorizationActionAttributes,
                                                                            OAuthAuthorizationResourceAttributes oAuthAuthorizationResourceAttributes,
                                                                            ContextAttributes contextAttributes)
    {
        // TODO: Perform decision and return appropriate AuthorizationResult
        return AuthorizationResult.notApplicable();
    }

}
