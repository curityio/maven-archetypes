package ${package}.${pluginName};

import se.curity.identityserver.sdk.authenticationaction.AuthenticationAction;
import se.curity.identityserver.sdk.plugin.descriptor.AuthenticationActionPluginDescriptor;

public final class ${pluginName}AuthenticationActionDescriptor implements AuthenticationActionPluginDescriptor<${pluginName}AuthenticationActionConfig> {

    @Override
    public Class<? extends AuthenticationAction> getAuthenticationAction()
    {
        return ${pluginName}AuthenticationAction.class;
    }

    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}AuthenticationActionConfig> getConfigurationType()
    {
        return ${pluginName}AuthenticationActionConfig.class;
    }    
}

