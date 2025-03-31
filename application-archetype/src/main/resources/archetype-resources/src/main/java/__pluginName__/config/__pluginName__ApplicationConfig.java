package ${package}.config;

import se.curity.identityserver.sdk.config.Configuration;
import se.curity.identityserver.sdk.config.annotation.Description;

import se.curity.identityserver.sdk.service.SessionManager;

public interface ${pluginName}ApplicationConfig extends Configuration
{
    @Description("A parameter used for demo purposes")
    Integer getDemoParameter();

    SessionManager getSessionManager();
}
