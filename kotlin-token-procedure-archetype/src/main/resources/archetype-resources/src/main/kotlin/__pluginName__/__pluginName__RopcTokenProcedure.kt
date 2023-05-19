package ${package}.${pluginName}

import se.curity.identityserver.sdk.data.tokens.TokenIssuerException
import se.curity.identityserver.sdk.procedure.token.RopcTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.RopcTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel

import java.time.Instant

class ${pluginName}RopcTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): RopcTokenProcedure
{
    private val accessTokenIssuer = _configuration.getAccessTokenIssuer()
    private val refreshTokenIssuer = _configuration.getRefreshTokenIssuer()

    override fun run(context: RopcTokenProcedurePluginContext): ResponseModel
    {
        val delegationData = context.defaultDelegationData
        val issuedDelegation = context.delegationIssuer.issue(delegationData)

        val accessTokenData = context.defaultAccessTokenData
        return try
        {
            val issuedAccessToken = accessTokenIssuer.issue(accessTokenData, issuedDelegation)
            val refreshTokenData = context.defaultRefreshTokenData
            val issuedRefreshToken = refreshTokenIssuer.issue(refreshTokenData, issuedDelegation)

            ResponseModel.mapResponseModel(mapOf(
                "scope" to accessTokenData.scope,
                "access_token" to issuedAccessToken,
                "refresh_token" to issuedRefreshToken,
                "token_type" to "bearer",
                "expires_in" to accessTokenData.expires.epochSecond - Instant.now().epochSecond
            ))
        } catch (e: TokenIssuerException)
        {
            ResponseModel.problemResponseModel("token_issuer_exception", "Could not issue new tokens")
        }
    }
}
