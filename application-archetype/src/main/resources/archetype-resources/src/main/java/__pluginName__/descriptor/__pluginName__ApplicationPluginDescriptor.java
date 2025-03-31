package ${package}.descriptor;

import se.curity.identityserver.sdk.plugin.descriptor.ApplicationPluginDescriptor;
import se.curity.identityserver.sdk.web.RequestHandler;

import ${package}.config.${pluginName}ApplicationConfig;
import ${package}.handler.${pluginName}ApplicationRequestHandler;

import java.util.Map;

import static java.util.Collections.singletonMap;
import static java.util.Collections.unmodifiableMap;

public final class ${pluginName}ApplicationPluginDescriptor implements ApplicationPluginDescriptor<${pluginName}ApplicationConfig>
{
    @Override
    public Map<String, Class<? extends RequestHandler<?>>> getAnonymousRequestHandlerTypes()
    {
        return unmodifiableMap(singletonMap("index", ${pluginName}ApplicationRequestHandler.class));
    }

    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}ApplicationConfig> getConfigurationType()
    {
        return ${pluginName}ApplicationConfig.class;
    }
}
