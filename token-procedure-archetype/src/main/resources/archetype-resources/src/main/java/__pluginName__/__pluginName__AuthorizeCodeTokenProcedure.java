package ${package}.${pluginName};

import se.curity.identityserver.sdk.data.tokens.TokenIssuerException;
import se.curity.identityserver.sdk.procedure.token.AuthorizeCodeTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.context.AuthorizeTokenProcedurePluginContext;
import se.curity.identityserver.sdk.procedure.token.context.OpenIdConnectAuthorizeTokenProcedurePluginContext;
import se.curity.identityserver.sdk.service.issuer.NonceIssuer;
import se.curity.identityserver.sdk.web.ResponseModel;

import java.util.HashMap;

public final class ${pluginName}AuthorizeCodeTokenProcedure implements AuthorizeCodeTokenProcedure
{
    private final ${pluginName}TokenProcedureConfig _configuration;
    private final NonceIssuer authorizationCodeIssuer;

    public ${pluginName}AuthorizeCodeTokenProcedure(${pluginName}TokenProcedureConfig configuration)
    {
        _configuration = configuration;
        authorizationCodeIssuer = _configuration.getAuthorizationCodeIssuer();
    }

    @Override
    public ResponseModel run(AuthorizeTokenProcedurePluginContext context)
    {
        var authorizationCodeData = context.getDefaultAuthorizationCodeData();

        try
        {
            var issuedAuthorizationCode = authorizationCodeIssuer.issue(authorizationCodeData);

            var responseData = new HashMap<String, Object>(4);
            responseData.put("code", issuedAuthorizationCode);
            responseData.put("state", context.getProvidedState());
            responseData.put("iss", context.getIssuer());

            if (context.getScopeNames().contains("openid"))
            {
                if (context instanceof OpenIdConnectAuthorizeTokenProcedurePluginContext)
                {
                    responseData.put("session_state", ((OpenIdConnectAuthorizeTokenProcedurePluginContext) context).getSessionState());
                }
            }

            return ResponseModel.mapResponseModel(responseData);
        }
        catch (TokenIssuerException e)
        {
            return ResponseModel.problemResponseModel("token_issuer_exception", "Could not issue new tokens");
        }
    }
}
