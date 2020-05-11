package ${package}.${pluginName};

import se.curity.identityserver.sdk.config.Configuration;
import se.curity.identityserver.sdk.config.annotation.Description;

public interface ${pluginName}DataAccessProviderConfig extends Configuration
{
    @Description("A parameter used for demo purposes")
    String getDemoConnectionUri();
}
