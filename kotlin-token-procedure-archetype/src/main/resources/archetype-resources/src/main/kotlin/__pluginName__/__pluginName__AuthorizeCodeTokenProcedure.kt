package ${package}.${pluginName}

import se.curity.identityserver.sdk.data.tokens.TokenIssuerException
import se.curity.identityserver.sdk.procedure.token.AuthorizeCodeTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.AuthorizeTokenProcedurePluginContext
import se.curity.identityserver.sdk.procedure.token.context.OpenIdConnectAuthorizeTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel

class ${pluginName}AuthorizeCodeTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): AuthorizeCodeTokenProcedure
{
    private val authorizationCodeIssuer = _configuration.getAuthorizationCodeIssuer()

    override fun run(context: AuthorizeTokenProcedurePluginContext): ResponseModel
    {
        val authorizationCodeData = context.defaultAuthorizationCodeData
        return try
        {
            val issuedAuthorizationCode = authorizationCodeIssuer.issue(authorizationCodeData)
            val responseData = mutableMapOf<String, Any>(
                "code" to issuedAuthorizationCode,
                "state" to context.providedState,
                "iss" to context.issuer
            )

            if (context.scopeNames.contains("openid") && context is OpenIdConnectAuthorizeTokenProcedurePluginContext)
            {
                responseData["session_state"] = context.sessionState
            }

            ResponseModel.mapResponseModel(responseData)
        }
        catch (e: TokenIssuerException)
        {
            ResponseModel.problemResponseModel("token_issuer_exception", "Could not issue new tokens")
        }
    }
}
