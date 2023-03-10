package ${package}.${pluginName}

import se.curity.identityserver.sdk.data.tokens.TokenIssuerException
import se.curity.identityserver.sdk.procedure.token.ClientCredentialsTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.ClientCredentialsTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel

import java.time.Instant

class ${pluginName}ClientCredentialsTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): ClientCredentialsTokenProcedure
{

    override fun run(context: ClientCredentialsTokenProcedurePluginContext): ResponseModel
    {
        val delegationData = context.defaultDelegationData
        val issuedDelegation = context.delegationIssuer.issue(delegationData)
        val accessTokenData = context.defaultAccessTokenData

        return try
        {
            val issuedAccessToken = context.accessTokenIssuer.issue(accessTokenData, issuedDelegation)

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
