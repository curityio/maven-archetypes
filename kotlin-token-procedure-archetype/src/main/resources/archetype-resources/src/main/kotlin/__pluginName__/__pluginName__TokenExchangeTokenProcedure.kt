package ${package}.${pluginName}

import se.curity.identityserver.sdk.data.tokens.TokenIssuerException
import se.curity.identityserver.sdk.procedure.token.TokenExchangeTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.TokenExchangeTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel

import java.time.Instant

class ${pluginName}TokenExchangeTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): TokenExchangeTokenProcedure
{
    override fun run(context: TokenExchangeTokenProcedurePluginContext): ResponseModel
    {
        val accessTokenData = context.getDefaultAccessTokenData(context.delegation)
        return try
        {
            val issuedAccessToken = context.accessTokenIssuer.issue(accessTokenData, context.delegation)

            ResponseModel.mapResponseModel(mapOf(
                "scope" to accessTokenData.scope,
                "access_token" to issuedAccessToken,
                "token_type" to "bearer",
                "expires_in" to accessTokenData.expires.epochSecond - Instant.now().epochSecond
            ))
        }
        catch (e: TokenIssuerException)
        {
            ResponseModel.problemResponseModel("token_issuer_exception", "Could not issue new tokens")
        }
    }
}
