package ${package}.descriptor

import ${package}.authentication.${pluginName}AuthenticatorRequestHandler
import ${package}.config.${pluginName}AuthenticatorPluginConfig
import se.curity.identityserver.sdk.authentication.AuthenticatorRequestHandler
import se.curity.identityserver.sdk.plugin.descriptor.AuthenticatorPluginDescriptor

class ${pluginName}AuthenticatorPluginDescriptor : AuthenticatorPluginDescriptor<${pluginName}AuthenticatorPluginConfig>
{
    override fun getAuthenticationRequestHandlerTypes(): Map<String, Class<out AuthenticatorRequestHandler<*>>> =
            mapOf("index" to ${pluginName}AuthenticatorRequestHandler::class.java)

    override fun getConfigurationType(): Class<out ${pluginName}AuthenticatorPluginConfig> =
        ${pluginName}AuthenticatorPluginConfig::class.java

    override fun getPluginImplementationType(): String = "${pluginName.toLowerCase()}"
}