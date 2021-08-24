package ${package}.config;

import se.curity.identityserver.sdk.config.Configuration
import se.curity.identityserver.sdk.service.SessionManager

interface ${pluginName}AuthenticatorPluginConfig : Configuration
{
    val sessionManager : SessionManager
}
