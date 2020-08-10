package ${package}.${pluginName}

import se.curity.identityserver.sdk.plugin.descriptor.SmsPluginDescriptor
import se.curity.identityserver.sdk.service.sms.SmsSender

class ${pluginName}SmsDescriptor: SmsPluginDescriptor<${pluginName}SmsConfig>
{
    override fun getSmsSenderType(): Class<out SmsSender> = ${pluginName}SmsSender::class.java

    override fun getPluginImplementationType(): String =  "${pluginName.toLowerCase()}"

    override fun getConfigurationType(): Class<out ${pluginName}SmsConfig> = ${pluginName}SmsConfig::class.java
}
