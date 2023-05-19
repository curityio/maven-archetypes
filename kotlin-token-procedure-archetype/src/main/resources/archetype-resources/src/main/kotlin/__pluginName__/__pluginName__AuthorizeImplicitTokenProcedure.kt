package ${package}.${pluginName}

import se.curity.identityserver.sdk.attribute.Attribute
import se.curity.identityserver.sdk.attribute.token.IdTokenAttributes
import se.curity.identityserver.sdk.data.authorization.Delegation
import se.curity.identityserver.sdk.data.tokens.TokenIssuerException
import se.curity.identityserver.sdk.procedure.token.AuthorizeImplicitTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.AuthorizeTokenProcedurePluginContext
import se.curity.identityserver.sdk.procedure.token.context.OpenIdConnectAuthorizeTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel

import java.time.Instant

class ${pluginName}AuthorizeImplicitTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): AuthorizeImplicitTokenProcedure
{
    private val accessTokenIssuer = _configuration.getAccessTokenIssuer()
    private val idTokenIssuer = _configuration.getIdTokenIssuer()

    override fun run(context: AuthorizeTokenProcedurePluginContext): ResponseModel
    {
        val responseData = mutableMapOf<String, Any>(
            "state" to context.providedState,
            "iss" to context.issuer
        )

        var issuedDelegation: Delegation? = null

        return try
        {
            context.defaultAccessTokenData?.let {
                val delegationData = context.defaultDelegationData
                issuedDelegation = context.delegationIssuer.issue(delegationData)
                responseData["access_token"] = accessTokenIssuer.issue(it, issuedDelegation)
                responseData["token_type"] = "bearer"
                responseData["expires_in"] = it.expires.epochSecond - Instant.now().epochSecond
                responseData["scope"] = it.scope
            }

            context.defaultIdTokenData?.let {
                if (issuedDelegation == null)
                {
                    val delegationData = context.defaultDelegationData
                    issuedDelegation = context.delegationIssuer.issue(delegationData)
                }
                val idTokenData = if (responseData["access_token"] != null)
                {
                    IdTokenAttributes.of(
                        it.with(Attribute.of("at_hash", idTokenIssuer.atHash(responseData["access_token"]!! as String)))
                    )
                } else
                {
                    it
                }

                responseData["id_token"] = idTokenIssuer.issue(idTokenData, issuedDelegation)
            }

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
