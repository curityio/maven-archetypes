package ${package}.authentication

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import se.curity.identityserver.sdk.authentication.BackchannelStartAuthenticationResult
import se.curity.identityserver.sdk.authentication.BackchannelAuthenticationHandler
import se.curity.identityserver.sdk.authentication.BackchannelAuthenticationRequest
import se.curity.identityserver.sdk.authentication.BackchannelAuthenticationResult
import se.curity.identityserver.sdk.authentication.BackchannelAuthenticatorState

import java.util.Optional

class ${pluginName}BackchannelAuthenticatorRequestHandler
    : BackchannelAuthenticationHandler
{

    override fun startAuthentication(authReqId: String, authRequest: BackchannelAuthenticationRequest): BackchannelStartAuthenticationResult
    {
        TODO("Implement logic")
        return BackchannelStartAuthenticationResult.ok()
    }


    override fun checkAuthenticationStatus(authReqId: String): Optional<BackchannelAuthenticationResult>
    {
        TODO("Implement logic")
        return Optional.of(BackchannelAuthenticationResult(null,
            BackchannelAuthenticatorState.STARTED))
    }

    override fun cancelAuthenticationRequest(authReqId: String)
    {
        TODO("Implement logic")
    }

    companion object {
        private val _logger = LoggerFactory.getLogger(${pluginName}BackchannelAuthenticatorRequestHandler::class.java)
    }
}
