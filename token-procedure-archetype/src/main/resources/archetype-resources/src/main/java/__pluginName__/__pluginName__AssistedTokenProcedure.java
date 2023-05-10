package ${package}.${pluginName};

import se.curity.identityserver.sdk.data.tokens.TokenIssuerException;
import se.curity.identityserver.sdk.procedure.token.AssistedTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.context.AssistedTokenProcedurePluginContext;
import se.curity.identityserver.sdk.service.issuer.AccessTokenIssuer;
import se.curity.identityserver.sdk.web.ResponseModel;

import java.time.Instant;
import java.util.HashMap;

public final class ${pluginName}AssistedTokenProcedure implements AssistedTokenProcedure
{
    private final ${pluginName}TokenProcedureConfig _configuration;
    private final AccessTokenIssuer accessTokenIssuer;

    public ${pluginName}AssistedTokenProcedure(${pluginName}TokenProcedureConfig configuration)
    {
        _configuration = configuration;
        accessTokenIssuer = _configuration.getAccessTokenIssuer();
    }

    @Override
    public ResponseModel run(AssistedTokenProcedurePluginContext context)
    {
        var issuedToken = context.getIssuedToken();
        if (issuedToken != null)
        {
            var responseData = new HashMap<String, Object>(5);
            responseData.put("status", "success");
            responseData.put("access_token", issuedToken.getValue());
            responseData.put("expires_in", issuedToken.getExpiresAtInstant().getEpochSecond() - Instant.now().getEpochSecond());
            responseData.put("scope", issuedToken.getScope());
            responseData.put("subject", issuedToken.getSubject());

            return ResponseModel.mapResponseModel(responseData);
        }

        var delegationData = context.getDefaultDelegationData();
        var issuedDelegation = context.getDelegationIssuer().issue(delegationData);

        var accessTokenData = context.getDefaultAccessTokenData();
        try
        {
            var issuedAccessToken = accessTokenIssuer.issue(accessTokenData, issuedDelegation);

            var responseData = new HashMap<String, Object>(5);
            responseData.put("status", "success");
            responseData.put("access_token", issuedAccessToken);
            responseData.put("expires_in", accessTokenData.getExpires().getEpochSecond() - Instant.now().getEpochSecond());
            responseData.put("scope", accessTokenData.getScope());
            responseData.put("subject", context.subjectAttributes().getSubject());

            return ResponseModel.mapResponseModel(responseData);
        }
        catch (TokenIssuerException e)
        {
            return ResponseModel.problemResponseModel("token_issuer_exception", "Could not issue new tokens");
        }
    }
}
