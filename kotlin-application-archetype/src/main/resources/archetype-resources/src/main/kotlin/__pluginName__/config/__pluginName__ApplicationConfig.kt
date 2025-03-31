package ${package}.config;

import se.curity.identityserver.sdk.config.Configuration;
import se.curity.identityserver.sdk.config.annotation.Description;

import se.curity.identityserver.sdk.service.SessionManager

interface ${pluginName}ApplicationConfig: Configuration
{
    @Description("A parameter used for demo purposes")
    fun getDemoParameter(): Int;

    fun getSessionManager(): SessionManager;
}
