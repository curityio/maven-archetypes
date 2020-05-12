package ${package}.authentication;

import ${package}.config.${pluginName}AuthenticatorPluginConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.curity.identityserver.sdk.authentication.AuthenticationResult;
import se.curity.identityserver.sdk.authentication.AuthenticatorRequestHandler;
import se.curity.identityserver.sdk.service.ExceptionFactory;
import se.curity.identityserver.sdk.service.Json;
import se.curity.identityserver.sdk.service.authentication.AuthenticatorInformationProvider;
import se.curity.identityserver.sdk.web.Request;
import se.curity.identityserver.sdk.web.Response;

import java.util.Optional;

public final class ${pluginName}AuthenticatorRequestHandler implements AuthenticatorRequestHandler<RequestModel>
{
    private static final Logger _logger = LoggerFactory.getLogger(${pluginName}AuthenticatorRequestHandler.class);

    private final ${pluginName}AuthenticatorPluginConfig _config;
    private final AuthenticatorInformationProvider _authInfoProvider;
    private final ExceptionFactory _exceptionFactory;

    public ${pluginName}AuthenticatorRequestHandler(${pluginName}AuthenticatorPluginConfig config,
                                                    ExceptionFactory exceptionFactory,
                                                    AuthenticatorInformationProvider authInfoProvider)
    {
        _config = config;
        _exceptionFactory = exceptionFactory;
        _authInfoProvider = authInfoProvider;
    }

    @Override
    public Optional<AuthenticationResult> get(RequestModel requestModel, Response response)
    {
        _logger.info("GET request received for authentication authentication");

        return Optional.empty();
    }

    @Override
    public Optional<AuthenticationResult> post(RequestModel requestModel, Response response)
    {
        return Optional.empty();
    }

    @Override
    public RequestModel preProcess(Request request, Response response)
    {
        return new RequestModel(request);
    }
}
