package ${package}.${pluginName}

import se.curity.identityserver.sdk.plugin.descriptor.SigningConsentorPluginDescriptor

class ${pluginName}SigningConsentorDescriptor: SigningConsentorPluginDescriptor<${pluginName}ConsentorConfig>
{
    override fun getConsentorType() = ${pluginName}SigningConsentor::class.java

    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}ConsentorConfig::class.java
}
