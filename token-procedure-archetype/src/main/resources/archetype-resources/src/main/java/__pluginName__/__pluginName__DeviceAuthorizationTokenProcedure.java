package ${package}.${pluginName};

import se.curity.identityserver.sdk.attribute.Attribute;
import se.curity.identityserver.sdk.data.tokens.TokenIssuerException;
import se.curity.identityserver.sdk.procedure.token.DeviceAuthorizationTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.context.DeviceAuthorizationTokenProcedurePluginContext;
import se.curity.identityserver.sdk.service.issuer.AccessTokenIssuer;
import se.curity.identityserver.sdk.service.issuer.IdTokenIssuer;
import se.curity.identityserver.sdk.service.issuer.RefreshTokenIssuer;
import se.curity.identityserver.sdk.web.ResponseModel;

import java.time.Instant;
import java.util.HashMap;

public final class ${pluginName}DeviceAuthorizationTokenProcedure implements DeviceAuthorizationTokenProcedure
{
    private final ${pluginName}TokenProcedureConfig _configuration;
    private final AccessTokenIssuer accessTokenIssuer;
    private final RefreshTokenIssuer refreshTokenIssuer;
    private final IdTokenIssuer idTokenIssuer;

    public ${pluginName}DeviceAuthorizationTokenProcedure(${pluginName}TokenProcedureConfig configuration)
    {
        _configuration = configuration;
        accessTokenIssuer = _configuration.getAccessTokenIssuer();
        refreshTokenIssuer = _configuration.getRefreshTokenIssuer();
        idTokenIssuer = _configuration.getIdTokenIssuer();
    }

    @Override
    public ResponseModel run(DeviceAuthorizationTokenProcedurePluginContext context)
    {
        var delegationData = context.getDefaultDelegationData();
        var issuedDelegation = context.getDelegationIssuer().issue(delegationData);

        var accessTokenData = context.getDefaultAccessTokenData();

        try {
            var issuedAccessToken = accessTokenIssuer.issue(accessTokenData, issuedDelegation);

            var refreshTokenData = context.getDefaultRefreshTokenData();
            var issuedRefreshToken = refreshTokenIssuer.issue(refreshTokenData, issuedDelegation);

            var responseData = new HashMap<String, Object>(6);
            responseData.put("access_token", issuedAccessToken);
            responseData.put("scope", accessTokenData.getScope());
            responseData.put("refresh_token", issuedRefreshToken);
            responseData.put("token_type", "bearer");
            responseData.put("expires_in", accessTokenData.getExpires().getEpochSecond() - Instant.now().getEpochSecond());

            if (context.getScopeNames().contains("openid"))
            {
                var idTokenData = context.getDefaultIdTokenData();

                idTokenData.with(Attribute.of("at_hash", idTokenIssuer.atHash(issuedAccessToken)));

                responseData.put("id_token", idTokenIssuer.issue(idTokenData, issuedDelegation));
            }

            return ResponseModel.mapResponseModel(responseData);
        }
        catch (TokenIssuerException e)
        {
            return ResponseModel.problemResponseModel("token_issuer_exception", "Could not issue new tokens");
        }
    }
}
