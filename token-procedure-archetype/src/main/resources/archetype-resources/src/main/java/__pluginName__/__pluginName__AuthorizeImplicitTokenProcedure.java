package ${package}.${pluginName};

import se.curity.identityserver.sdk.attribute.Attribute;
import se.curity.identityserver.sdk.data.authorization.Delegation;
import se.curity.identityserver.sdk.data.tokens.TokenIssuerException;
import se.curity.identityserver.sdk.procedure.token.AuthorizeImplicitTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.context.AuthorizeTokenProcedurePluginContext;
import se.curity.identityserver.sdk.procedure.token.context.OpenIdConnectAuthorizeTokenProcedurePluginContext;
import se.curity.identityserver.sdk.web.ResponseModel;

import java.time.Instant;
import java.util.HashMap;


public final class ${pluginName}AuthorizeImplicitTokenProcedure implements AuthorizeImplicitTokenProcedure
{
    private final ${pluginName}TokenProcedureConfig _configuration;

    public ${pluginName}AuthorizeImplicitTokenProcedure(${pluginName}TokenProcedureConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public ResponseModel run(AuthorizeTokenProcedurePluginContext context)
    {
        var responseData = new HashMap<String, Object>(8);
        responseData.put("state", context.getProvidedState());
        responseData.put("iss", context.getIssuer());

        String issuedAccessToken = null;
        Delegation issuedDelegation = null;

        try
        {
            var accessTokenData = context.getDefaultAccessTokenData();
            if (accessTokenData != null)
            {
                var delegationData = context.getDefaultDelegationData();
                issuedDelegation = context.getDelegationIssuer().issue(delegationData);

                issuedAccessToken = context.getAccessTokenIssuer().issue(accessTokenData, issuedDelegation);

                responseData.put("access_token", issuedAccessToken);
                responseData.put("token_type", "bearer");
                responseData.put("expires_in", accessTokenData.getExpires().getEpochSecond() - Instant.now().getEpochSecond());
                responseData.put("scope", accessTokenData.getScope());
            }

            var idTokenData = context.getDefaultIdTokenData();
            if (idTokenData != null)
            {
                if (issuedDelegation == null)
                {
                    var delegationData = context.getDefaultDelegationData();
                    issuedDelegation = context.getDelegationIssuer().issue(delegationData);
                }

                var idTokenIssuer = context.getIdTokenIssuer();
                idTokenData.with(Attribute.of("at_hash", idTokenIssuer.atHash(issuedAccessToken)));

                responseData.put("id_token", idTokenIssuer.issue(idTokenData, issuedDelegation));
            }

            if (context.getScopeNames().contains("openid") && context instanceof OpenIdConnectAuthorizeTokenProcedurePluginContext)
            {
                responseData.put("session_state",((OpenIdConnectAuthorizeTokenProcedurePluginContext) context).getSessionState());
            }

            return ResponseModel.mapResponseModel(responseData);
        }
        catch (TokenIssuerException e)
        {
            return ResponseModel.problemResponseModel("token_issuer_exception", "Could not issue new tokens");
        }

    }
}
