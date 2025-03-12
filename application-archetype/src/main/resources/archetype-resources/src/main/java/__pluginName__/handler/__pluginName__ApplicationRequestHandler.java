package ${package}.handler;

import ${package}.config.${pluginName}ApplicationConfig;
import se.curity.identityserver.sdk.web.HttpRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.curity.identityserver.sdk.authentication.AuthenticationResult;
import se.curity.identityserver.sdk.service.ExceptionFactory;
import se.curity.identityserver.sdk.service.Json;
import se.curity.identityserver.sdk.web.Request;
import se.curity.identityserver.sdk.web.Response;

public final class ${pluginName}ApplicationRequestHandler implements HttpRequestHandler<RequestModel>
{
    private static final Logger _logger = LoggerFactory.getLogger(${pluginName}ApplicationRequestHandler.class);

    private final ${pluginName}ApplicationConfig _config;
    private final ExceptionFactory _exceptionFactory;

    public ${pluginName}ApplicationRequestHandler(${pluginName}ApplicationConfig config,
            ExceptionFactory exceptionFactory)
    {
        _config = config;
        _exceptionFactory = exceptionFactory;
    }

    @Override
    public ApplicationGetResponseModel get(RequestModel requestModel, Response response)
    {
        _logger.info("GET request received for application plugin");

        return new ApplicationGetResponseModel();
    }

    @Override
    public ApplicationPostResponseModel post(RequestModel requestModel, Response response)
    {
        _logger.info("POST request received for application plugin");

        return new ApplicationPostResponseModel();
    }

    @Override
    public RequestModel preProcess(Request request, Response response)
    {
        return new RequestModel(request);
    }
}
