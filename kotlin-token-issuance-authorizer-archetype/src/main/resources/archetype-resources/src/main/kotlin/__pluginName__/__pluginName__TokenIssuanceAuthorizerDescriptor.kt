package ${package}.${pluginName}

import se.curity.identityserver.sdk.plugin.descriptor.TokenIssuanceAuthorizerPluginDescriptor

class ${pluginName}TokenIssuanceAuthorizerDescriptor: TokenIssuanceAuthorizerPluginDescriptor<${pluginName}TokenIssuanceAuthorizerConfig>
{
    override fun getTokenIssuanceAuthorizer() = ${pluginName}TokenIssuanceAuthorizer::class.java

    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}TokenIssuanceAuthorizerConfig::class.java
}
