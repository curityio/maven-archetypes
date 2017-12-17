package ${package}.authentication;

import ${package}.config.${pluginName}AuthenticatorPluginConfig;
import io.curity.identityserver.plugin.authentication.DefaultOAuthClient;
import io.curity.identityserver.plugin.authentication.OAuthClient;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import se.curity.identityserver.sdk.authentication.AuthenticationResult;
import se.curity.identityserver.sdk.authentication.AuthenticatorRequestHandler;
import se.curity.identityserver.sdk.service.ExceptionFactory;
import se.curity.identityserver.sdk.service.Json;
import se.curity.identityserver.sdk.service.authentication.AuthenticatorInformationProvider;
import se.curity.identityserver.sdk.web.Request;
import se.curity.identityserver.sdk.web.Response;

import java.util.Map;
import java.util.Optional;

import static io.curity.identityserver.plugin.authentication.Constants.Params.PARAM_ACCESS_TOKEN;

public class CallbackRequestHandler
        implements AuthenticatorRequestHandler<CallbackRequestModel> {

    private final ExceptionFactory _exceptionFactory;
    private final OAuthClient _oauthClient;
    private final ${pluginName}AuthenticatorPluginConfig _config;

    public CallbackRequestHandler(ExceptionFactory exceptionFactory,
                                  AuthenticatorInformationProvider provider,
                                  Json json,
                                  ${pluginName}AuthenticatorPluginConfig config) {
        _exceptionFactory = exceptionFactory;
        _oauthClient = new DefaultOAuthClient(exceptionFactory, provider, json, config.getSessionManager());
        _config = config;
    }

    @Override
    public CallbackRequestModel preProcess(Request request, Response response) {
        if (request.isGetRequest()) {
            return new CallbackRequestModel(request);
        } else {
            throw _exceptionFactory.methodNotAllowed();
        }
    }

    @Override
    public Optional<AuthenticationResult> get(CallbackRequestModel requestModel,
                                              Response response) {
        _oauthClient.redirectToAuthenticationOnError(requestModel.getRequest(), _config.id());

        Map<String, Object> tokenMap = _oauthClient.getTokens(_config.getTokenEndpoint().toString(),
                _config.getClientId(),
                _config.getClientSecret(),
                requestModel.getCode(),
                requestModel.getState());

        return _oauthClient.getAuthenticationResult(
            tokenMap.get(PARAM_ACCESS_TOKEN).toString(), _config.getUserInfoEndpoint().toString());
    }

    @Override
    public Optional<AuthenticationResult> post(CallbackRequestModel requestModel, Response response) {
        throw _exceptionFactory.methodNotAllowed();
    }
}
