package ${package}.${pluginName}

import se.curity.identityserver.sdk.oauth.consent.Consentor
import se.curity.identityserver.sdk.plugin.descriptor.ConsentorPluginDescriptor

class ${pluginName}ConsentorDescriptor: ConsentorPluginDescriptor<${pluginName}ConsentorConfig>
{
    override fun getConsentorType(): Class<out Consentor> = ${pluginName}Consentor::class.java

    override fun getPluginImplementationType(): String = "${pluginName.toLowerCase()}"

    override fun getConfigurationType(): Class<out ${pluginName}ConsentorConfig> = ${pluginName}ConsentorConfig::class.java
}
