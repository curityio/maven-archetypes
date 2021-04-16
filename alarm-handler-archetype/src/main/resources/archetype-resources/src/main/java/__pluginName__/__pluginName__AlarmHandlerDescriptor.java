package ${package}.${pluginName};

import se.curity.identityserver.sdk.plugin.descriptor.AlarmHandlerPluginDescriptor;
import se.curity.identityserver.sdk.alarm.AlarmHandler;

public final class ${pluginName}AlarmHandlerDescriptor implements AlarmHandlerPluginDescriptor<${pluginName}AlarmHandlerConfig>
{
    @Override
    public Class<? extends AlarmHandler> getAlarmHandler() {
        return ${pluginName}AlarmHandler.class;
    }

    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}AlarmHandlerConfig> getConfigurationType()
    {
        return ${pluginName}AlarmHandlerConfig.class;
    }    
}
