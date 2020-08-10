package ${package}.${pluginName}

import se.curity.identityserver.sdk.authenticationaction.AuthenticationAction
import se.curity.identityserver.sdk.plugin.descriptor.AuthenticationActionPluginDescriptor

class ${pluginName}AuthenticationActionDescriptor: AuthenticationActionPluginDescriptor<${pluginName}AuthenticationActionConfig>
{
    override fun getAuthenticationAction(): Class<out AuthenticationAction> = ${pluginName}AuthenticationAction::class.java

    override fun getPluginImplementationType(): String = "${pluginName.toLowerCase()}"

    override fun getConfigurationType(): Class<out ${pluginName}AuthenticationActionConfig> = ${pluginName}AuthenticationActionConfig::class.java;
}
