package ${package}.${pluginName};

import se.curity.identityserver.sdk.attribute.ContextAttributes;
import se.curity.identityserver.sdk.attribute.SubjectAttributes;
import se.curity.identityserver.sdk.authorization.AuthorizationResult;
import se.curity.identityserver.sdk.authorization.ScimObligation;
import se.curity.identityserver.sdk.authorization.scim.ScimAuthorizationActionAttributes;
import se.curity.identityserver.sdk.authorization.scim.ScimAuthorizationManager;
import se.curity.identityserver.sdk.authorization.scim.ScimAuthorizationResourceAttributes;

public final class ${pluginName}ScimAuthorizationManager implements ScimAuthorizationManager
{
    private final ${pluginName}AuthorizationManagerConfig _configuration;

    public ${pluginName}ScimAuthorizationManager(${pluginName}AuthorizationManagerConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public AuthorizationResult<ScimObligation> getScimAuthorizationResult(SubjectAttributes subjectAttributes,
                                                                          ScimAuthorizationActionAttributes scimAuthorizationActionAttributes,
                                                                          ScimAuthorizationResourceAttributes scimAuthorizationResourceAttributes,
                                                                          ContextAttributes contextAttributes)
    {
        // TODO: Perform decision and return appropriate AuthorizationResult
        return AuthorizationResult.notApplicable();
    }

}
