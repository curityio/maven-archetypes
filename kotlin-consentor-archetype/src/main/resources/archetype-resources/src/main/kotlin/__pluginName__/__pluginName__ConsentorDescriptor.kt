package ${package}.${pluginName}

import se.curity.identityserver.sdk.plugin.descriptor.ConsentorPluginDescriptor

class ${pluginName}ConsentorDescriptor: ConsentorPluginDescriptor<${pluginName}ConsentorConfig>
{
    override fun getConsentorType() = ${pluginName}Consentor::class.java

    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}ConsentorConfig::class.java
}
