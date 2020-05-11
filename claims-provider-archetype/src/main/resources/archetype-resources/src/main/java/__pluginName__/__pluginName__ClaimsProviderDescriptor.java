package ${package}.${pluginName};

import se.curity.identityserver.sdk.claims.ClaimsProvider;
import se.curity.identityserver.sdk.plugin.descriptor.ClaimsProviderPluginDescriptor;

public final class ${pluginName}ClaimsProviderDescriptor implements ClaimsProviderPluginDescriptor<${pluginName}ClaimsProviderConfig>
{
    @Override
    public Class<? extends ClaimsProvider> getClaimsProvider()
    {
        return ${pluginName}ClaimsProvider.class;
    }

    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}ClaimsProviderConfig> getConfigurationType()
    {
        return ${pluginName}ClaimsProviderConfig.class;
    }
}
