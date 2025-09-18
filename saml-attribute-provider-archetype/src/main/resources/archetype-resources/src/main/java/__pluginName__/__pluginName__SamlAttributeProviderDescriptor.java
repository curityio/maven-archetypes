package ${package}.${pluginName};

import se.curity.identityserver.sdk.saml.SamlAttributeProvider;
import se.curity.identityserver.sdk.plugin.descriptor.SamlAttributeProviderPluginDescriptor;

public final class ${pluginName}SamlAttributeProviderDescriptor implements SamlAttributeProviderPluginDescriptor<${pluginName}SamlAttributeProviderConfig>
{
    @Override
    public Class<? extends SamlAttributeProvider> getSamlAttributeProvider()
    {
        return ${pluginName}SamlAttributeProvider.class;
    }

    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}SamlAttributeProviderConfig> getConfigurationType()
    {
        return ${pluginName}SamlAttributeProviderConfig.class;
    }
}
