package ${package}.${pluginName};

import se.curity.identityserver.sdk.config.Configuration;
import se.curity.identityserver.sdk.config.annotation.Description;

public interface ${pluginName}AlarmHandlerConfig extends Configuration
{
    @Description("A parameter used for demo purposes")
    Integer getDemoParameter();
}
