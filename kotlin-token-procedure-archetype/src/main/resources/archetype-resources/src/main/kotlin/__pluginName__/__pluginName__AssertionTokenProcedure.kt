package ${package}.${pluginName}

import se.curity.identityserver.sdk.data.tokens.TokenIssuerException
import se.curity.identityserver.sdk.procedure.token.AssertionTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.AssertionTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel

import java.time.Instant

class ${pluginName}AssertionTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): AssertionTokenProcedure
{

    override fun run(context: AssertionTokenProcedurePluginContext): ResponseModel
    {
        val delegationData = context.defaultDelegationData
        val issuedDelegation = context.delegationIssuer.issue(delegationData)

        val accessTokenData = context.defaultAccessTokenData

        return try
        {
            ResponseModel.mapResponseModel(mapOf(
                "scope" to accessTokenData.scope,
                "access_token" to context.accessTokenIssuer.issue(accessTokenData, issuedDelegation),
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
