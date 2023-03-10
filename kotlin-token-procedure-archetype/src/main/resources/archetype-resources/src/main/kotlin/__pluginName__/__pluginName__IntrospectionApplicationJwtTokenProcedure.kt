package ${package}.${pluginName}

import se.curity.identityserver.sdk.attribute.token.AccessTokenAttributes
import se.curity.identityserver.sdk.data.tokens.TokenIssuerException
import se.curity.identityserver.sdk.procedure.token.IntrospectionApplicationJwtTokenProcedure
import se.curity.identityserver.sdk.procedure.token.context.IntrospectionTokenProcedurePluginContext
import se.curity.identityserver.sdk.web.ResponseModel

class ${pluginName}IntrospectionApplicationJwtTokenProcedure(private val _configuration: ${pluginName}TokenProcedureConfig): IntrospectionApplicationJwtTokenProcedure
{

    override fun run(context: IntrospectionTokenProcedurePluginContext): ResponseModel
    {
        if (context.presentedToken.isActive)
        {
            context.defaultAccessTokenJwtIssuer?.let { jwtIssuer ->
                context.delegation?.let { delegation ->
                    return try {
                        ResponseModel.mapResponseModel(mapOf(
                            "jwt" to jwtIssuer.issue(AccessTokenAttributes.of(context.presentedToken.tokenData), delegation),
                            "active" to true
                        ))
                    }
                    catch (e: TokenIssuerException)
                    {
                        ResponseModel.problemResponseModel("token_issuer_exception", "Could not introspect token")
                    }
                }
            }
        }

        return ResponseModel.mapResponseModel(emptyMap())
    }
}
