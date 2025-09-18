package ${package}.${pluginName}

import se.curity.identityserver.sdk.plugin.descriptor.SamlAttributeProviderPluginDescriptor

class ${pluginName}SamlAttributeProviderDescriptor: SamlAttributeProviderPluginDescriptor<${pluginName}SamlAttributeProviderConfig>
{
    override fun getSamlAttributeProvider() = ${pluginName}SamlAttributeProvider::class.java

    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}SamlAttributeProviderConfig::class.java
}
