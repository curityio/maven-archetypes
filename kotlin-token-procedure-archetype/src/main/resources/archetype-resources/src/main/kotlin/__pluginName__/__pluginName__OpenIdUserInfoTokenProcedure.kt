package ${package}.${pluginName}

import se.curity.identityserver.sdk.procedure.token.OpenIdUserInfoTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.OpenIdUserInfoTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel

class ${pluginName}OpenIdUserInfoTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): OpenIdUserInfoTokenProcedure
{

    override fun run(context: OpenIdUserInfoTokenProcedurePluginContext): ResponseModel
    {
        val responseData = context.defaultResponseData.asMap()

        context.accountAttributes?.name?.formatted?.let {
            responseData["name"] = it
        }

        val presentedTokenData = context.presentedToken.tokenData
        responseData["scope"] = presentedTokenData.getMandatoryValue("scope", String::class.java)

        context.presentedToken.tokenDelegation?.let {
            responseData["client_id"] = it.clientId
        }

        context.accountAttributes?.let {
            responseData["preferred_username"] = it.userName
        }

        return ResponseModel.mapResponseModel(responseData)
    }
}
