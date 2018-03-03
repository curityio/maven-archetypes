package ${package}.descriptor;

import com.google.common.collect.ImmutableMap;
import ${package}.authentication.${pluginName}AuthenticatorRequestHandler;
import ${package}.config.${pluginName}AuthenticatorPluginConfig;
import se.curity.identityserver.sdk.authentication.AuthenticatorRequestHandler;
import se.curity.identityserver.sdk.plugin.descriptor.AuthenticatorPluginDescriptor;

import java.util.Map;

public final class ${pluginName}AuthenticatorPluginDescriptor implements AuthenticatorPluginDescriptor<${pluginName}AuthenticatorPluginConfig> {

    @Override
    public String getPluginImplementationType() {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}AuthenticatorPluginConfig> getConfigurationType() {
        return ${pluginName}AuthenticatorPluginConfig.class;
    }

    @Override
    public Map<String, Class<? extends AuthenticatorRequestHandler<?>>> getAuthenticationRequestHandlerTypes() {
        return ImmutableMap.of("index", ${pluginName}AuthenticatorRequestHandler.class);
    }
}
