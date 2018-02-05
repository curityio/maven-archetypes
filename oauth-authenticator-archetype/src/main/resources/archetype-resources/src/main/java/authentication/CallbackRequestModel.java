package ${package}.authentication;

import se.curity.identityserver.sdk.Nullable;
import se.curity.identityserver.sdk.web.Request;

import java.util.function.Function;

class CallbackRequestModel
{
    @Nullable
    private final String _error;

    @Nullable
    private final String _errorDescription;

    private final String _url;
    private final String _code;
    private final String _state;

    CallbackRequestModel(Request request)
    {
        Function<String, ? extends RuntimeException> invalidParameter = (s) -> new RuntimeException(String.format(
                "Expected only one query string parameter named %s, but found multiple.", s));

        _code = request.getQueryParameterValueOrError("code", invalidParameter);
        _state = request.getQueryParameterValueOrError("state", invalidParameter);
        _error = request.getQueryParameterValueOrError("error", invalidParameter);
        _errorDescription = request.getQueryParameterValueOrError("error_description", invalidParameter);
        _url = request.getUrl();
    }

    public String getCode()
    {
        return _code;
    }

    public String getState()
    {
        return _state;
    }

    @Nullable
    public String getErrorDescription()
    {
        return _errorDescription;
    }

    public String getRequestUrl()
    {
        return _url;
    }

    @Nullable
    public String getError()
    {
        return _error;
    }
}
