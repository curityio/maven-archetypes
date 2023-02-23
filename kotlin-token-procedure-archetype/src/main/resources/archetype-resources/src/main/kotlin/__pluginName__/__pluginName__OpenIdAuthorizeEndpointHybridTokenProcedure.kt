package ${package}.${pluginName}

import se.curity.identityserver.sdk.attribute.Attribute
import se.curity.identityserver.sdk.attribute.token.IdTokenAttributes
import se.curity.identityserver.sdk.data.authorization.Delegation
import se.curity.identityserver.sdk.data.tokens.TokenIssuerException
import se.curity.identityserver.sdk.procedure.token.OpenIdAuthorizeEndpointHybridTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.OpenIdConnectAuthorizeTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel

import java.util.ArrayList

class ${pluginName}OpenIdAuthorizeEndpointHybridTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): OpenIdAuthorizeEndpointHybridTokenProcedure
{

    override fun run(context: OpenIdConnectAuthorizeTokenProcedurePluginContext): ResponseModel
    {
        val authorizationCodeData = context.defaultAuthorizationCodeData
        return try
        {
            val issuedAuthorizationCode = context.authorizationCodeIssuer.issue(authorizationCodeData)
            val responseData = mutableMapOf<String, Any>(
                "code" to issuedAuthorizationCode,
                "state" to context.providedState,
                "iss" to context.issuer
            )
            var issuedDelegation: Delegation? = null

            context.defaultAccessTokenData?.let {
                issuedDelegation = context.delegationIssuer.issue(context.defaultDelegationData)

                responseData["access_token"] = context.accessTokenIssuer.issue(it, issuedDelegation)
                responseData["token_type"] = "bearer"
                responseData["scope"] = it.scope
            }

            context.defaultIdTokenData?.let { idTokenData ->
                issuedDelegation = issuedDelegation ?: context.delegationIssuer.issue(context.defaultDelegationData)
                val idTokenIssuer = context.idTokenIssuer

                val hashClaims = mutableListOf(Attribute.of("c_hash", idTokenIssuer.cHash(issuedAuthorizationCode)))
                responseData["access_token"]?.let {
                    hashClaims.add(Attribute.of("at_hash", idTokenIssuer.atHash(it as String)))
                }

                responseData["id_token"] = idTokenIssuer.issue(
                    IdTokenAttributes.of(idTokenData.with(hashClaims)),
                    issuedDelegation
                )
            }

            ResponseModel.mapResponseModel(responseData)
        }
        catch (e: TokenIssuerException)
        {
            ResponseModel.problemResponseModel("token_issuer_exception", "Could not issue new tokens")
        }
    }
}
