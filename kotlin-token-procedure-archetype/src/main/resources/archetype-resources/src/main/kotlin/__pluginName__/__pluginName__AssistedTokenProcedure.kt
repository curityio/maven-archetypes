package ${package}.${pluginName}

import se.curity.identityserver.sdk.data.tokens.TokenIssuerException
import se.curity.identityserver.sdk.procedure.token.AssistedTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.AssistedTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel

import java.time.Instant

class ${pluginName}AssistedTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): AssistedTokenProcedure
{
    private val accessTokenIssuer = _configuration.getAccessTokenIssuer()

    override fun run(context: AssistedTokenProcedurePluginContext): ResponseModel
    {
        context.issuedToken?.let {
            return ResponseModel.mapResponseModel(mapOf(
                "status" to "success",
                "access_token" to it.value,
                "expires_in" to it.expiresAtInstant.epochSecond - Instant.now().epochSecond,
                "scope" to it.scope,
                "subject" to it.subject
            ))
        }

        val delegationData = context.defaultDelegationData
        val issuedDelegation = context.delegationIssuer.issue(delegationData)

        val accessTokenData = context.defaultAccessTokenData
        return try
        {
            val issuedAccessToken = accessTokenIssuer.issue(accessTokenData, issuedDelegation)

            ResponseModel.mapResponseModel(mapOf(
                "status" to "success",
                "access_token" to issuedAccessToken,
                "expires_in" to accessTokenData.expires.epochSecond - Instant.now().epochSecond,
                "scope" to accessTokenData.scope,
                "subject" to context.subjectAttributes().subject,
            ))
        }
        catch (e: TokenIssuerException)
        {
            ResponseModel.problemResponseModel("token_issuer_exception", "Could not issue new tokens")
        }
    }
}
