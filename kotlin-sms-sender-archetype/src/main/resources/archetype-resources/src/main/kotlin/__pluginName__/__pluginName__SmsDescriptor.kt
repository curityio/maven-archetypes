package ${package}.${pluginName}

import se.curity.identityserver.sdk.plugin.descriptor.SmsPluginDescriptor

class ${pluginName}SmsDescriptor: SmsPluginDescriptor<${pluginName}SmsConfig>
{
    override fun getSmsSenderType() = ${pluginName}SmsSender::class.java

    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}SmsConfig::class.java
}
