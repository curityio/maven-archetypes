package ${package}.${pluginName}

import se.curity.identityserver.sdk.procedure.token.IntrospectionTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.IntrospectionTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel

class ${pluginName}IntrospectionTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): IntrospectionTokenProcedure
{

    override fun run(context: IntrospectionTokenProcedurePluginContext): ResponseModel
    {
        val presentedToken = context.presentedToken
        val responseData = mutableMapOf<String, Any>(
            "active" to presentedToken.isActive
        )

        if (presentedToken.isActive)
        {
            responseData.putAll(presentedToken.tokenData.asMap())
            responseData["token_type"] = presentedToken.type
            responseData["client_id"] = presentedToken.tokenDelegation.clientId
            responseData["expired_scope"] = presentedToken.expiredScopes
        }

        return ResponseModel.mapResponseModel(responseData)
    }
}
