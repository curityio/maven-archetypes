package ${package}.${pluginName};

import se.curity.identityserver.sdk.plugin.descriptor.AlarmHandlerPluginDescriptor;
import se.curity.identityserver.sdk.alarm.AlarmHandler;

class ${pluginName}AlarmHandlerDescriptor: AlarmHandlerPluginDescriptor<${pluginName}AlarmHandlerConfig>
{
    override fun getAlarmHandler() = ${pluginName}AlarmHandler::class.java

    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}AlarmHandlerConfig::class.java;
}
