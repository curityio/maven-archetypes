package ${package}.${pluginName};

import se.curity.identityserver.sdk.oauth.consent.signing.SigningConsentor;
import se.curity.identityserver.sdk.plugin.descriptor.SigningConsentorPluginDescriptor;

public final class ${pluginName}SigningConsentorDescriptor implements SigningConsentorPluginDescriptor<${pluginName}ConsentorConfig> {

    @Override
    public Class<? extends SigningConsentor> getConsentorType()
    {
        return ${pluginName}SigningConsentor.class;
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
