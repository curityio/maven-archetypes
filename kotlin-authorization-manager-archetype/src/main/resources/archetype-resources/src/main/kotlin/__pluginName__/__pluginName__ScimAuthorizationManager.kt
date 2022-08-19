package ${package}.${pluginName};

import se.curity.identityserver.sdk.attribute.ContextAttributes;
import se.curity.identityserver.sdk.attribute.SubjectAttributes;
import se.curity.identityserver.sdk.authorization.AuthorizationResult;
import se.curity.identityserver.sdk.authorization.ScimObligation;
import se.curity.identityserver.sdk.authorization.scim.ScimAuthorizationActionAttributes;
import se.curity.identityserver.sdk.authorization.scim.ScimAuthorizationManager;
import se.curity.identityserver.sdk.authorization.scim.ScimAuthorizationResourceAttributes;

class ${pluginName}ScimAuthorizationManager(private val _configuration:${pluginName}AuthorizationManagerConfig): ScimAuthorizationManager
{
    override fun getScimAuthorizationResult(subjectAttributes: SubjectAttributes ,
                                            scimAuthorizationActionAttributes: ScimAuthorizationActionAttributes,
                                            scimAuthorizationResourceAttributes: ScimAuthorizationResourceAttributes,
                                            contextAttributes: ContextAttributes)
        : AuthorizationResult<ScimObligation>
    {
        // TODO: Perform decision and return appropriate AuthorizationResult
        return AuthorizationResult.notApplicable();
    }

}
