package ${package}.${pluginName}

import se.curity.identityserver.sdk.attribute.Attribute
import se.curity.identityserver.sdk.attribute.token.IdTokenAttributes
import se.curity.identityserver.sdk.data.tokens.TokenIssuerException
import se.curity.identityserver.sdk.procedure.token.DeviceAuthorizationTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.DeviceAuthorizationTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel

import java.time.Instant

class ${pluginName}DeviceAuthorizationTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): DeviceAuthorizationTokenProcedure
{
    private val accessTokenIssuer = _configuration.getAccessTokenIssuer()
    private val refreshTokenIssuer = _configuration.getRefreshTokenIssuer()
    private val idTokenIssuer = _configuration.getIdTokenIssuer()

    override fun run(context: DeviceAuthorizationTokenProcedurePluginContext): ResponseModel
    {
        val delegationData = context.defaultDelegationData
        val issuedDelegation = context.delegationIssuer.issue(delegationData)

        val accessTokenData = context.defaultAccessTokenData

        return try
        {
            val issuedAccessToken = accessTokenIssuer.issue(accessTokenData, issuedDelegation)
            val refreshTokenData = context.defaultRefreshTokenData
            val issuedRefreshToken = refreshTokenIssuer.issue(refreshTokenData, issuedDelegation)
            val responseData = mutableMapOf<String, Any>(
                "access_token" to issuedAccessToken,
                "scope" to accessTokenData.scope,
                "refresh_token" to issuedRefreshToken,
                "token_type" to "bearer",
                "expires_in" to accessTokenData.expires.epochSecond - Instant.now().epochSecond
            )

            if (context.scopeNames.contains("openid"))
            {
                context.defaultIdTokenData?.let {
                    responseData["id_token"] = idTokenIssuer.issue(IdTokenAttributes.of(
                        it.with(Attribute.of("at_hash", idTokenIssuer.atHash(issuedAccessToken)))
                    ), issuedDelegation)
                }
            }

            ResponseModel.mapResponseModel(responseData)
        }
        catch (e: TokenIssuerException)
        {
            ResponseModel.problemResponseModel("token_issuer_exception", "Could not issue new tokens")
        }
    }
}
