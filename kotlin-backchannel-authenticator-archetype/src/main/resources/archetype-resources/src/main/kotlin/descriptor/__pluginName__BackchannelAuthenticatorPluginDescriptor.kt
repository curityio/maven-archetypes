package ${package}.descriptor

import ${package}.authentication.${pluginName}BackchannelAuthenticatorRequestHandler
import ${package}.config.${pluginName}BackchannelAuthenticatorPluginConfig
import se.curity.identityserver.sdk.Nullable
import se.curity.identityserver.sdk.authentication.BackchannelAuthenticationHandler
import se.curity.identityserver.sdk.plugin.descriptor.AuthenticatorPluginDescriptor
import se.curity.identityserver.sdk.plugin.descriptor.BackchannelAuthenticatorPluginDescriptor


class ${pluginName}BackchannelAuthenticatorPluginDescriptor : BackchannelAuthenticatorPluginDescriptor<${pluginName}BackchannelAuthenticatorPluginConfig>
{
    override fun getBackchannelAuthenticationHandlerType(): Class<out BackchannelAuthenticationHandler>
    {
        return ${pluginName}BackchannelAuthenticatorRequestHandler::class.java
    }

    override @Nullable fun getFrontchannelPluginDescriptorReference(): Class<out AuthenticatorPluginDescriptor<*>>
    {
        return ${pluginName}AuthenticatorPluginDescriptor::class.java
    }

    override fun getConfigurationType(): Class<out ${pluginName}BackchannelAuthenticatorPluginConfig> =
        ${pluginName}BackchannelAuthenticatorPluginConfig::class.java

    override fun getPluginImplementationType(): String = "${pluginName.toLowerCase()}"
}
