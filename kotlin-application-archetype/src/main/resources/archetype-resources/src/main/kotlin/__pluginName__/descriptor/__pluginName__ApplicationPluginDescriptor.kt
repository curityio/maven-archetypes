package ${package}.descriptor;

import se.curity.identityserver.sdk.plugin.descriptor.ApplicationPluginDescriptor;
import se.curity.identityserver.sdk.web.HttpRequestHandler;

import ${package}.config.${pluginName}ApplicationConfig;
import ${package}.handler.${pluginName}ApplicationRequestHandler;

class ${pluginName}ApplicationPluginDescriptor: ApplicationPluginDescriptor<${pluginName}ApplicationConfig> {

    override fun getAnonymousRequestHandlerTypes() = linkedMapOf(
        "index" to ${pluginName}ApplicationRequestHandler::class.java
    )

    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}ApplicationConfig::class.java
}
