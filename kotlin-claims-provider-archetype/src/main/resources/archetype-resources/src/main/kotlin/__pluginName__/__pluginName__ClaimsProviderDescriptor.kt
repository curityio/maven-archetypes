package ${package}.${pluginName}

import se.curity.identityserver.sdk.claims.ClaimsProvider
import se.curity.identityserver.sdk.plugin.descriptor.ClaimsProviderPluginDescriptor

class ${pluginName}ClaimsProviderDescriptor: ClaimsProviderPluginDescriptor<${pluginName}ClaimsProviderConfig>
{
    override fun getClaimsProvider(): Class<out ClaimsProvider> = ${pluginName}ClaimsProvider::class.java

    override fun getPluginImplementationType(): String = "${pluginName.toLowerCase()}"

    override fun getConfigurationType(): Class<out ${pluginName}ClaimsProviderConfig> = ${pluginName}ClaimsProviderConfig::class.java
}
