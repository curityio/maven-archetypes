package ${package}.${pluginName}

import se.curity.identityserver.sdk.email.Emailer
import se.curity.identityserver.sdk.plugin.descriptor.EmailProviderPluginDescriptor

class ${pluginName}EmailProviderDescriptor: EmailProviderPluginDescriptor<${pluginName}EmailProviderConfig>
{
    override fun getEmailSenderType(): Class<out Emailer> = ${pluginName}EmailSender::class.java

    override fun getPluginImplementationType(): String = "${pluginName.toLowerCase()}"

    override fun getConfigurationType(): Class<out ${pluginName}EmailProviderConfig> = ${pluginName}EmailProviderConfig::class.java
}
