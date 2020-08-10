package ${package}.descriptor

import ${package}.authentication.CallbackRequestHandler
import ${package}.authentication.${pluginName}AuthenticatorRequestHandler
import ${package}.config.${pluginName}AuthenticatorPluginConfig
import se.curity.identityserver.sdk.authentication.AuthenticatorRequestHandler
import se.curity.identityserver.sdk.plugin.descriptor.AuthenticatorPluginDescriptor

class ${pluginName}AuthenticatorPluginDescriptor: AuthenticatorPluginDescriptor<${pluginName}AuthenticatorPluginConfig>
{

    override fun getPluginImplementationType(): String = "${pluginName.toLowerCase()}"

    override fun getConfigurationType(): Class<out ${pluginName}AuthenticatorPluginConfig> = ${pluginName}AuthenticatorPluginConfig::class.java

    override fun getAuthenticationRequestHandlerTypes(): Map<String, Class<out AuthenticatorRequestHandler<*>>> =
        linkedMapOf(
            Pair("index", ${pluginName}AuthenticatorRequestHandler::class.java),
            Pair(CALLBACK, CallbackRequestHandler::class.java)
        )

    companion object
    {
        const val CALLBACK: String = "callback"
    }
}
