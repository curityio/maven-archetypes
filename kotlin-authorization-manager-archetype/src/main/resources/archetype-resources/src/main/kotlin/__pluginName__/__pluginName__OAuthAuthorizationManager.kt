package ${package}.${pluginName}

import se.curity.identityserver.sdk.attribute.ContextAttributes
import se.curity.identityserver.sdk.attribute.SubjectAttributes
import se.curity.identityserver.sdk.authorization.OAuthObligation
import se.curity.identityserver.sdk.authorization.oauth.OAuthAuthorizationActionAttributes
import se.curity.identityserver.sdk.authorization.oauth.OAuthAuthorizationManager
import se.curity.identityserver.sdk.authorization.oauth.OAuthAuthorizationResourceAttributes

class ${pluginName}OAuthAuthorizationManager(private val _configuration: ${pluginName}AuthorizationManagerConfig): OAuthAuthorizationManager
{
    override fun  getOAuthAuthorizationResult(subjectAttributes: SubjectAttributes ,
                                     oAuthAuthorizationActionAttributes: OAuthAuthorizationActionAttributes ,
                                     oAuthAuthorizationResourceAttributes: OAuthAuthorizationResourceAttributes ,
                                     contextAttributes: ContextAttributes)
        : AuthorizationResult<OAuthObligation>
    {
        // TODO: Perform decision and return appropriate AuthorizationResult
        TODO("Not implemented")
    }

}
