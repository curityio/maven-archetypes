package ${package}.config;

import se.curity.identityserver.sdk.config.Configuration;
import se.curity.identityserver.sdk.config.annotation.DefaultString;
import se.curity.identityserver.sdk.config.annotation.DefaultURI;
import se.curity.identityserver.sdk.config.annotation.Description;
import se.curity.identityserver.sdk.service.SessionManager;

import java.net.URI;

@SuppressWarnings("InterfaceNeverImplemented")
public interface ${pluginName}AuthenticatorPluginConfig extends Configuration {

	@Description("Client id")
    String getClientId();

    @Description("Secret key")
    String getClientSecret();

    @Description("URL to the upstream OAuth server's authorization endpoint")
    @DefaultURI("https://identity.example.com/authorize")
    URI getAuthorizationEndpoint();

    @Description("URL to the upstream OAuth server's token endpoint")
    @DefaultURI("https://identity.example.com/token")
    URI getTokenEndpoint();

    @Description("URL to upstream OpenID Connect Provider's user info endpoint")
    @DefaultURI("https://identity.example.com/user-info")
    URI getUserInfoEndpoint();

    @Description("A space-separated list of scopes to request from Custom")
    @DefaultString("")
    String getScope();

    SessionManager getSessionManager();
}
