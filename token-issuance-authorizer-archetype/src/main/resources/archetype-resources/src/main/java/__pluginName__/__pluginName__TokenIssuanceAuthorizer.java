package ${package}.${pluginName};

import se.curity.identityserver.sdk.data.authorization.ScopeValue;
import se.curity.identityserver.sdk.oauth.tokenissuanceauthorizers.TokenIssuanceAuthorizer;
import se.curity.identityserver.sdk.oauth.tokenissuanceauthorizers.TokenIssuanceAuthorizerContext;
import se.curity.identityserver.sdk.oauth.tokenissuanceauthorizers.TokenIssuanceAuthorizerResult;

import java.util.Collection;

public final class ${pluginName}TokenIssuanceAuthorizer implements TokenIssuanceAuthorizer
{
    private final ${pluginName}TokenIssuanceAuthorizerConfig _configuration;

    public ${pluginName}TokenIssuanceAuthorizer(${pluginName}TokenIssuanceAuthorizerConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public TokenIssuanceAuthorizerResult authorize(TokenIssuanceAuthorizerContext context, Collection<ScopeValue> scopeValues)
    {
        // TODO: Decide which of the scopes can be issued and return the decisions, e.g.
        // TokenIssuanceAuthorizerResult.builder().allow("read").deny("write").build()
        // A scope that this authorizer does not allow is not issued. You can also require user consent for a scope, or set
        // its time to live. The context contains information about the client, the user's authentication and the request.
        // Use context.getPhase() to check whether the authorizer runs before or after claims are resolved. After claims
        // are resolved (POST_CLAIMS_RESOLUTION), their values are available in context.getResolvedClaims(), but the
        // authorizer can only restrict what was allowed before.
        // See the interface's JavaDoc or https://curity.io/docs/idsvr-java-plugin-sdk/latest/se/curity/identityserver/sdk/oauth/tokenissuanceauthorizers/TokenIssuanceAuthorizer.html for more details.
        throw new UnsupportedOperationException();
    }
}
