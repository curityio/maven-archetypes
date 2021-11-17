package ${package}.descriptor;

import ${package}.authentication.${pluginName}BackchannelAuthenticatorRequestHandler;
import ${package}.config.${pluginName}BackchannelAuthenticatorPluginConfig;
import se.curity.identityserver.sdk.Nullable;
import se.curity.identityserver.sdk.authentication.BackchannelAuthenticationHandler;
import se.curity.identityserver.sdk.plugin.descriptor.AuthenticatorPluginDescriptor;
import se.curity.identityserver.sdk.plugin.descriptor.BackchannelAuthenticatorPluginDescriptor;

public final class ${pluginName}BackchannelAuthenticatorPluginDescriptor implements BackchannelAuthenticatorPluginDescriptor<${pluginName}BackchannelAuthenticatorPluginConfig>
{
    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}BackchannelAuthenticatorPluginConfig> getConfigurationType()
    {
        return ${pluginName}BackchannelAuthenticatorPluginConfig.class;
    }

    @Override
    public Class<? extends BackchannelAuthenticationHandler> getBackchannelAuthenticationHandlerType()
    {
        return ${pluginName}BackchannelAuthenticatorRequestHandler.class;
    }

    @Override
    public @Nullable Class<? extends AuthenticatorPluginDescriptor<?>> getFrontchannelPluginDescriptorReference()
    {
        return ${pluginName}AuthenticatorPluginDescriptor.class;
    }
}
