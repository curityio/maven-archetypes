package ${package}.${pluginName};

import se.curity.identityserver.sdk.attribute.Attribute;
import se.curity.identityserver.sdk.attribute.token.IdTokenAttributes;
import se.curity.identityserver.sdk.data.authorization.Delegation;
import se.curity.identityserver.sdk.data.tokens.TokenIssuerException;
import se.curity.identityserver.sdk.procedure.token.OpenIdAuthorizeEndpointHybridTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.context.OpenIdConnectAuthorizeTokenProcedurePluginContext;
import se.curity.identityserver.sdk.web.ResponseModel;

import java.util.ArrayList;
import java.util.HashMap;

public final class ${pluginName}OpenIdAuthorizeEndpointHybridTokenProcedure implements OpenIdAuthorizeEndpointHybridTokenProcedure
{
    private final ${pluginName}TokenProcedureConfig _configuration;

    public ${pluginName}OpenIdAuthorizeEndpointHybridTokenProcedure(${pluginName}TokenProcedureConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public ResponseModel run(OpenIdConnectAuthorizeTokenProcedurePluginContext context)
    {
        var authorizationCodeData = context.getDefaultAuthorizationCodeData();
        try
        {
            var issuedAuthorizationCode = context.getAuthorizationCodeIssuer().issue(authorizationCodeData);

            var responseData = new HashMap<String, Object>(7);
            responseData.put("code", issuedAuthorizationCode);
            responseData.put("state", context.getProvidedState());
            responseData.put("iss", context.getIssuer());

            String issuedAccessToken = null;
            Delegation issuedDelegation = null;

            var accessTokenData = context.getDefaultAccessTokenData();
            if (accessTokenData != null)
            {
                var delegationData = context.getDefaultDelegationData();
                issuedDelegation = context.getDelegationIssuer().issue(delegationData);

                issuedAccessToken = context.getAccessTokenIssuer().issue(accessTokenData, issuedDelegation);

                responseData.put("access_token", issuedAccessToken);
                responseData.put("token_type", "bearer");
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
                var idTokenHashClaims = new ArrayList<Attribute>(2);
                idTokenHashClaims.add(Attribute.of("c_hash", idTokenIssuer.cHash(issuedAuthorizationCode)));
                idTokenHashClaims.add(Attribute.of("at_hash", idTokenIssuer.atHash(issuedAccessToken)));
                idTokenData = IdTokenAttributes.of(idTokenData.with(idTokenHashClaims));

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
