package ${package}.authentication

import se.curity.identityserver.sdk.web.Request

class CallbackRequestModel(request: Request)
{
    val error: String? = request.getQueryParameterValueOrError("error", invalidParameter)
    val errorDescription: String? = request.getQueryParameterValueOrError("error_description", invalidParameter)
    val url: String = request.url
    val code: String = request.getQueryParameterValueOrError("code", invalidParameter)
    val state: String = request.getQueryParameterValueOrError("state", invalidParameter)

    companion object
    {
        private val invalidParameter = { s: String -> RuntimeException(String.format(
                "Expected only one query string parameter named %s, but found multiple.", s)) }
    }
}
