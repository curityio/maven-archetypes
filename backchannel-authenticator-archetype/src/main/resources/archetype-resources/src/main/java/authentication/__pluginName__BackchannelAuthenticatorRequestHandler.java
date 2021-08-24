package ${package}.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.curity.identityserver.sdk.authentication.BackchannelStartAuthenticationResult;
import se.curity.identityserver.sdk.authentication.BackchannelAuthenticationHandler;
import se.curity.identityserver.sdk.authentication.BackchannelAuthenticationRequest;
import se.curity.identityserver.sdk.authentication.BackchannelAuthenticationResult;
import se.curity.identityserver.sdk.authentication.BackchannelAuthenticatorState;

import java.util.Optional;

public final class ${pluginName}BackchannelAuthenticatorRequestHandler implements BackchannelAuthenticationHandler
{
    private static final Logger _logger = LoggerFactory.getLogger(${pluginName}BackchannelAuthenticatorRequestHandler.class);

    public ${pluginName}BackchannelAuthenticatorRequestHandler()
    {
    }

    @Override
    public BackchannelStartAuthenticationResult startAuthentication(String authReqId,
                                                                    BackchannelAuthenticationRequest authRequest)
    {
        // @TODO Implement logic
        return BackchannelStartAuthenticationResult.ok();
    }

    @Override
    public Optional<BackchannelAuthenticationResult> checkAuthenticationStatus(String authReqId)
    {
        // @TODO Implement logic
        return Optional.of(new BackchannelAuthenticationResult(null,
                           BackchannelAuthenticatorState.STARTED));
    }

    @Override
    public void cancelAuthenticationRequest(String authReqId)
    {
        // @TODO Implement logic
    }
}
