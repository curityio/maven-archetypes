package ${package}.${pluginName};

import se.curity.identityserver.sdk.plugin.descriptor.SmsPluginDescriptor;
import se.curity.identityserver.sdk.service.sms.SmsSender;

public final class ${pluginName}SmsDescriptor implements SmsPluginDescriptor<${pluginName}SmsConfig>
{
    @Override
    public Class<? extends SmsSender> getSmsSenderType()
    {
        return ${pluginName}SmsSender.class;
    }

    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}SmsConfig> getConfigurationType()
    {
        return ${pluginName}SmsConfig.class;
    }    
}
