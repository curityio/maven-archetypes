package ${package}.${pluginName}

import se.curity.identityserver.sdk.oauth.consent.signing.SigningConsentor
import se.curity.identityserver.sdk.plugin.descriptor.SigningConsentorPluginDescriptor

class ${pluginName}SigningConsentorDescriptor: SigningConsentorPluginDescriptor<${pluginName}ConsentorConfig>
{
    override fun getConsentorType(): Class<out SigningConsentor> = ${pluginName}SigningConsentor::class.java

    override fun getPluginImplementationType(): String = "${pluginName.toLowerCase()}"

    override fun getConfigurationType(): Class<out ${pluginName}ConsentorConfig> = ${pluginName}ConsentorConfig::class.java
}
