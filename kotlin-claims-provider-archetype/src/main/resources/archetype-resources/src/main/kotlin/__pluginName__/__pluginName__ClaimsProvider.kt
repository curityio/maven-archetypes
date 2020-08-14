package ${package}.${pluginName}

import se.curity.identityserver.sdk.attribute.Attributes
import se.curity.identityserver.sdk.attribute.AuthenticationAttributes
import se.curity.identityserver.sdk.claims.ClaimsProvider
import se.curity.identityserver.sdk.claims.RequestedClaimAttribute
import se.curity.identityserver.sdk.data.authorization.ScopeValue
import se.curity.identityserver.sdk.oauth.OAuthClient

class ${pluginName}ClaimsProvider(private val _configuration: ${pluginName}ClaimsProviderConfig): ClaimsProvider
{
    // See examples of Claims Providers on GitHub: https://github.com/search?q=topic%3Aclaims-provider+org%3Acurityio

    override fun getClaimValues(requestedClaimAttributes: Set<RequestedClaimAttribute>,
                                scopeValues: Set<ScopeValue>,
                                userAuthenticationAttributes: AuthenticationAttributes,
                                client: OAuthClient): Attributes
    {
        TODO()
    }
}
