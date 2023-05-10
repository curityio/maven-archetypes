package ${package}.${pluginName};

import se.curity.identityserver.sdk.data.tokens.TokenIssuerException;
import se.curity.identityserver.sdk.procedure.token.ClientCredentialsTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.context.ClientCredentialsTokenProcedurePluginContext;
import se.curity.identityserver.sdk.service.issuer.AccessTokenIssuer;
import se.curity.identityserver.sdk.web.ResponseModel;

import java.time.Instant;
import java.util.HashMap;

public final class ${pluginName}ClientCredentialsTokenProcedure implements ClientCredentialsTokenProcedure
{
    private final ${pluginName}TokenProcedureConfig _configuration;
    private final AccessTokenIssuer accessTokenIssuer;

    public ${pluginName}ClientCredentialsTokenProcedure(${pluginName}TokenProcedureConfig configuration)
    {
        _configuration = configuration;
        accessTokenIssuer = _configuration.getAccessTokenIssuer();
    }

    @Override
    public ResponseModel run(ClientCredentialsTokenProcedurePluginContext context)
    {
        var delegationData = context.getDefaultDelegationData();
        var issuedDelegation = context.getDelegationIssuer().issue(delegationData);

        var accessTokenData = context.getDefaultAccessTokenData();

        try
        {
            var issuedAccessToken = accessTokenIssuer.issue(accessTokenData, issuedDelegation);

            var responseData = new HashMap<String, Object>(4);

            responseData.put("scope", accessTokenData.getScope());
            responseData.put("access_token", issuedAccessToken);
            responseData.put("token_type", "bearer");
            responseData.put("expires_in", accessTokenData.getExpires().getEpochSecond() - Instant.now().getEpochSecond());

            return ResponseModel.mapResponseModel(responseData);
        }
        catch (TokenIssuerException e)
        {
           return ResponseModel.problemResponseModel("token_issuer_exception", "Could not issue new tokens");
        }
    }
}
