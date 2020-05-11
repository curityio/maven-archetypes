package ${package}.${pluginName};

import se.curity.identityserver.sdk.oauth.consent.Consentor;
import se.curity.identityserver.sdk.plugin.descriptor.ConsentorPluginDescriptor;

public final class ${pluginName}ConsentorDescriptor implements ConsentorPluginDescriptor<${pluginName}ConsentorConfig> {

    @Override
    public Class<? extends Consentor> getConsentorType()
    {
        return ${pluginName}Consentor.class;
    }

    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}ConsentorConfig> getConfigurationType()
    {
        return ${pluginName}ConsentorConfig.class;
    }
}
