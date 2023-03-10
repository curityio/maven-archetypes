package ${package}.${pluginName};

import se.curity.identityserver.sdk.procedure.token.IntrospectionTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.context.IntrospectionTokenProcedurePluginContext;
import se.curity.identityserver.sdk.web.ResponseModel;

import java.util.HashMap;

public final class ${pluginName}IntrospectionTokenProcedure implements IntrospectionTokenProcedure
{
    private final ${pluginName}TokenProcedureConfig _configuration;

    public ${pluginName}IntrospectionTokenProcedure(${pluginName}TokenProcedureConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public ResponseModel run(IntrospectionTokenProcedurePluginContext context)
    {
        var responseData = new HashMap<String, Object>();
        var presentedToken = context.getPresentedToken();

        responseData.put("active", presentedToken.isActive());

        if (presentedToken.isActive())
        {
            responseData.putAll(presentedToken.getTokenData().asMap());
            responseData.put("token_type", presentedToken.getType());
            responseData.put("client_id", presentedToken.getTokenDelegation().getClientId());
            responseData.put("expired_scope", presentedToken.getExpiredScopes());
        }

        return ResponseModel.mapResponseModel(responseData);
    }
}
