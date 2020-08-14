package ${package}.${pluginName}

import se.curity.identityserver.sdk.plugin.descriptor.EmailProviderPluginDescriptor

class ${pluginName}EmailProviderDescriptor: EmailProviderPluginDescriptor<${pluginName}EmailProviderConfig>
{
    override fun getEmailSenderType() = ${pluginName}EmailSender::class.java

    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}EmailProviderConfig::class.java
}
