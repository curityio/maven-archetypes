package ${package}.${pluginName};

import se.curity.identityserver.sdk.attribute.Attributes;
import se.curity.identityserver.sdk.attribute.AuthenticationAttributes;
import se.curity.identityserver.sdk.claims.ClaimsProvider;
import se.curity.identityserver.sdk.claims.RequestedClaimAttribute;
import se.curity.identityserver.sdk.data.authorization.ScopeValue;
import se.curity.identityserver.sdk.oauth.OAuthClient;

import java.util.Set;

public final class ${pluginName}ClaimsProvider implements ClaimsProvider
{
    private final ${pluginName}ClaimsProviderConfig _configuration;

    public ${pluginName}ClaimsProvider(${pluginName}ClaimsProviderConfig configuration)
    {
        _configuration = configuration;

        // See examples of Claims Providers on GitHub: https://github.com/search?q=topic%3Aclaims-provider+org%3Acurityio
    }

    @Override
    public Attributes getClaimValues(Set<RequestedClaimAttribute> requestedClaimAttributes,
                                     Set<ScopeValue> scopeValues,
                                     AuthenticationAttributes userAuthenticationAttributes,
                                     OAuthClient client)
    {
        throw new UnsupportedOperationException();
    }
}
