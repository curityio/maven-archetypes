package ${package}.${pluginName};

import se.curity.identityserver.sdk.data.tokens.TokenIssuerException;
import se.curity.identityserver.sdk.procedure.token.RefreshTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.context.RefreshTokenProcedurePluginContext;
import se.curity.identityserver.sdk.web.ResponseModel;
import java.time.Instant;
import java.util.HashMap;

public final class ${pluginName}RefreshTokenProcedure implements RefreshTokenProcedure
{
    private final ${pluginName}TokenProcedureConfig _configuration;

    public ${pluginName}RefreshTokenProcedure(${pluginName}TokenProcedureConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public ResponseModel run(RefreshTokenProcedurePluginContext pluginContext)
    {
        var accessTokenData = pluginContext.getDefaultAccessTokenData(pluginContext.getDelegation());
        String issuedAccessToken = null;
        try
        {
            issuedAccessToken = pluginContext.getAccessTokenIssuer().issue(accessTokenData, pluginContext.getDelegation());
            var refreshToken = pluginContext.getPresentedToken().getValue();

            if (refreshToken == null)
            {
                var refreshTokenData = pluginContext.getDefaultRefreshTokenData();
                refreshToken = pluginContext.getRefreshTokenIssuer().issue(refreshTokenData, pluginContext.getDelegation());
            }

            var responseMap = new HashMap<String, Object>(5);
            responseMap.put("scope", accessTokenData.getScope());
            responseMap.put("access_token", issuedAccessToken);
            responseMap.put("refresh_token", refreshToken);
            responseMap.put("token_type", "bearer");
            responseMap.put("expires_in", accessTokenData.getExpires().getEpochSecond() - Instant.now().getEpochSecond());

            return ResponseModel.mapResponseModel(responseMap);
        }
        catch (TokenIssuerException e)
        {
            return ResponseModel.problemResponseModel("token_issuer_exception", "Could not issue new tokens");
        }
    }
}
