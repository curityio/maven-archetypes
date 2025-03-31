package ${package}.handler;

import ${package}.config.${pluginName}ApplicationConfig;
import se.curity.identityserver.sdk.web.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.curity.identityserver.sdk.authentication.AuthenticationResult;
import se.curity.identityserver.sdk.service.ExceptionFactory;
import se.curity.identityserver.sdk.service.Json;
import se.curity.identityserver.sdk.web.Request;
import se.curity.identityserver.sdk.web.Response;

class ${pluginName}ApplicationRequestHandler(private val _config: ${pluginName}ApplicationConfig, private val _exceptionFactory: ExceptionFactory): RequestHandler<RequestModel>
{
    override fun preProcess(request: Request, response: Response): RequestModel
    {
        return RequestModel();
    }

    override fun get(requestModel: RequestModel, response: Response): ApplicationGetResponse
    {
        _logger.info("GET request received for application plugin");

        return ApplicationGetResponse();
    }

    override fun post(requestModel: RequestModel, response: Response): ApplicationPostResponse
    {
        _logger.info("POST request received for application plugin");

        return ApplicationPostResponse();
    }

    companion object
    {
        private val _logger: Logger = LoggerFactory.getLogger(${pluginName}ApplicationRequestHandler::class.java)

    }
}
