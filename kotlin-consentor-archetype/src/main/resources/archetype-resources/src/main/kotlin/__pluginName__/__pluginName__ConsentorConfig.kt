package ${package}.${pluginName}

import se.curity.identityserver.sdk.config.Configuration
import se.curity.identityserver.sdk.config.annotation.Description

interface ${pluginName}ConsentorConfig: Configuration
{
    @Description("A parameter used for demo purposes")
    fun getDemoParameter(): Int
}
