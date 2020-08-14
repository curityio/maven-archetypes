package ${package}.${pluginName}

import se.curity.identityserver.sdk.plugin.descriptor.AuthenticationActionPluginDescriptor

class ${pluginName}AuthenticationActionDescriptor: AuthenticationActionPluginDescriptor<${pluginName}AuthenticationActionConfig>
{
    override fun getAuthenticationAction() = ${pluginName}AuthenticationAction::class.java

    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}AuthenticationActionConfig::class.java;
}
