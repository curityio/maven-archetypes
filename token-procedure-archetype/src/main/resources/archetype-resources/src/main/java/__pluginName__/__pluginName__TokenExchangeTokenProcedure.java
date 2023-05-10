package ${package}.${pluginName};

import se.curity.identityserver.sdk.data.tokens.TokenIssuerException;
import se.curity.identityserver.sdk.procedure.token.TokenExchangeTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.context.TokenExchangeTokenProcedurePluginContext;
import se.curity.identityserver.sdk.service.issuer.AccessTokenIssuer;
import se.curity.identityserver.sdk.web.ResponseModel;

import java.time.Instant;
import java.util.HashMap;

public final class ${pluginName}TokenExchangeTokenProcedure implements TokenExchangeTokenProcedure
{
    private final ${pluginName}TokenProcedureConfig _configuration;
    private final AccessTokenIssuer accessTokenIssuer;

    public ${pluginName}TokenExchangeTokenProcedure(${pluginName}TokenProcedureConfig configuration)
    {
        _configuration = configuration;
        accessTokenIssuer = _configuration.getAccessTokenIssuer();
    }

    @Override
    public ResponseModel run(TokenExchangeTokenProcedurePluginContext context)
    {
        var accessTokenData = context.getDefaultAccessTokenData(context.getDelegation());
        try
        {
            var issuedAccessToken = accessTokenIssuer.issue(accessTokenData, context.getDelegation());

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
