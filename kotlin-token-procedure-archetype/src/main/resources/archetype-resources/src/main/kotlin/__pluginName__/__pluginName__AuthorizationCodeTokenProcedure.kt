package ${package}.${pluginName}

import se.curity.identityserver.sdk.attribute.Attribute
import se.curity.identityserver.sdk.attribute.token.IdTokenAttributes
import se.curity.identityserver.sdk.data.tokens.TokenIssuerException
import se.curity.identityserver.sdk.procedure.token.AuthorizationCodeTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.AuthorizationCodeTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel

import java.time.Instant

class ${pluginName}AuthorizationCodeTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): AuthorizationCodeTokenProcedure
{

    override fun run(context: AuthorizationCodeTokenProcedurePluginContext): ResponseModel
    {
        val delegationData = context.defaultDelegationData
        val issuedDelegation = context.delegationIssuer.issue(delegationData)

        val accessTokenData = context.defaultAccessTokenData

        return try
        {
            val issuedAccessToken = context.accessTokenIssuer.issue(accessTokenData, issuedDelegation)
            val refreshTokenData = context.defaultRefreshTokenData
            val issuedRefreshToken = context.refreshTokenIssuer.issue(refreshTokenData, issuedDelegation)
            val responseData = mutableMapOf<String, Any>(
                "access_token" to issuedAccessToken,
                "scope" to accessTokenData.scope,
                "refresh_token" to issuedRefreshToken,
                "token_type" to "bearer",
                "expires_in" to accessTokenData.expires.epochSecond - Instant.now().epochSecond
            )

            context.defaultIdTokenData?.let {
                val idTokenIssuer = context.idTokenIssuer

                responseData["id_token"] = idTokenIssuer.issue(IdTokenAttributes.of(
                    it.with(Attribute.of("at_hash", idTokenIssuer.atHash(issuedAccessToken)))
                ), issuedDelegation)
            }

            ResponseModel.mapResponseModel(responseData)
        }
        catch (e: TokenIssuerException)
        {
            ResponseModel.problemResponseModel("token_issuer_exception", "Could not issue new tokens")
        }
    }
}
