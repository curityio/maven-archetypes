package ${package}.${pluginName}

import se.curity.identityserver.sdk.data.tokens.TokenIssuerException
import se.curity.identityserver.sdk.procedure.token.RefreshTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.RefreshTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel
import java.time.Instant

class ${pluginName}RefreshTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): RefreshTokenProcedure
{

    override fun run(context: RefreshTokenProcedurePluginContext): ResponseModel
    {
        val accessTokenData = context.getDefaultAccessTokenData(context.delegation)
        return try
        {
            val issuedAccessToken = context.accessTokenIssuer.issue(accessTokenData, context.delegation)
            val refreshToken = context.presentedToken.value ?: context.refreshTokenIssuer.issue(context.defaultRefreshTokenData, context.delegation)

            ResponseModel.mapResponseModel(mapOf(
                "scope" to accessTokenData.scope,
                "access_token" to issuedAccessToken,
                "refresh_token" to refreshToken,
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
