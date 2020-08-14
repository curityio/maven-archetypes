package ${package}.${pluginName}

import se.curity.identityserver.sdk.plugin.descriptor.ClaimsProviderPluginDescriptor

class ${pluginName}ClaimsProviderDescriptor: ClaimsProviderPluginDescriptor<${pluginName}ClaimsProviderConfig>
{
    override fun getClaimsProvider() = ${pluginName}ClaimsProvider::class.java

    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}ClaimsProviderConfig::class.java
}
