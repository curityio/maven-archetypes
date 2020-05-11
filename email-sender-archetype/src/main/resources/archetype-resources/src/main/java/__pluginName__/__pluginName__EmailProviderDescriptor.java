package ${package}.${pluginName};

import se.curity.identityserver.sdk.email.Emailer;
import se.curity.identityserver.sdk.plugin.descriptor.EmailProviderPluginDescriptor;

public final class ${pluginName}EmailProviderDescriptor implements EmailProviderPluginDescriptor<${pluginName}EmailProviderConfig>
{
    @Override
    public Class<? extends Emailer> getEmailSenderType()
    {
        return ${pluginName}EmailSender.class;
    }

    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}EmailProviderConfig> getConfigurationType()
    {
        return ${pluginName}EmailProviderConfig.class;
    }    
}
