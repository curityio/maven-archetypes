package ${package}.descriptor;

import ${package}.authentication.CallbackRequestHandler;
import ${package}.authentication.${pluginName}AuthenticatorRequestHandler;
import ${package}.config.${pluginName}AuthenticatorPluginConfig;
import se.curity.identityserver.sdk.authentication.AuthenticatorRequestHandler;
import se.curity.identityserver.sdk.plugin.descriptor.AuthenticatorPluginDescriptor;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ${pluginName}AuthenticatorPluginDescriptor implements AuthenticatorPluginDescriptor<${pluginName}AuthenticatorPluginConfig> {

    public final static String CALLBACK = "callback";

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
        Map<String, Class<? extends AuthenticatorRequestHandler<?>>> handlers = new LinkedHashMap<>(2);
        handlers.put("index", ${pluginName}AuthenticatorRequestHandler.class);
        handlers.put(CALLBACK, CallbackRequestHandler.class);

        return Collections.unmodifiableMap(handlers);
    }
}
