package ${package}.authentication

import io.curity.identityserver.plugin.signicat.config.${pluginName}AuthenticatorPluginConfig
import se.curity.identityserver.sdk.authentication.AuthenticationResult
import se.curity.identityserver.sdk.authentication.AuthenticatorRequestHandler
import se.curity.identityserver.sdk.web.Request
import se.curity.identityserver.sdk.web.Response
import se.curity.identityserver.sdk.web.ResponseModel.templateResponseModel
import java.util.Optional
import java.util.Collections.emptyMap
import java.util.Collections.singletonMap

class ${pluginName}AuthenticatorRequestHandler(config : ${pluginName}AuthenticatorPluginConfig)
    : AuthenticatorRequestHandler<RequestModel>
{
    override fun preProcess(request: Request, response: Response): RequestModel = RequestModel(request)
    
    override fun get(requestModel: RequestModel, response: Response): Optional<AuthenticationResult>
    {
        TODO("not implemented")
    }
    
    override fun post(requestModel: RequestModel, response: Response): Optional<AuthenticationResult>
    {
        TODO("not implemented")
    }
}