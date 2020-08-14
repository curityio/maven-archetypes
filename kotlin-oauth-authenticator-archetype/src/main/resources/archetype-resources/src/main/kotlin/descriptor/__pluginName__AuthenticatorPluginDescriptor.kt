package ${package}.descriptor

import ${package}.authentication.CallbackRequestHandler
import ${package}.authentication.${pluginName}AuthenticatorRequestHandler
import ${package}.config.${pluginName}AuthenticatorPluginConfig
import se.curity.identityserver.sdk.plugin.descriptor.AuthenticatorPluginDescriptor

class ${pluginName}AuthenticatorPluginDescriptor: AuthenticatorPluginDescriptor<${pluginName}AuthenticatorPluginConfig>
{

    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}AuthenticatorPluginConfig::class.java

    override fun getAuthenticationRequestHandlerTypes() = linkedMapOf(
        "index" to ${pluginName}AuthenticatorRequestHandler::class.java,
        CALLBACK to CallbackRequestHandler::class.java
    )

    companion object
    {
        const val CALLBACK: String = "callback"
    }
}
