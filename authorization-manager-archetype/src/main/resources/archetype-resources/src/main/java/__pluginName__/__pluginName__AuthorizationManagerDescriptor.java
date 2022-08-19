package ${package}.${pluginName};

import se.curity.identityserver.sdk.Nullable;
import se.curity.identityserver.sdk.authorization.graphql.GraphQLAuthorizationManager;
import se.curity.identityserver.sdk.authorization.oauth.OAuthAuthorizationManager;
import se.curity.identityserver.sdk.authorization.scim.ScimAuthorizationManager;
import se.curity.identityserver.sdk.plugin.descriptor.AuthorizationManagerPluginDescriptor;

public final class ${pluginName}AuthorizationManagerDescriptor implements AuthorizationManagerPluginDescriptor<${pluginName}AuthorizationManagerConfig>
{
    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}AuthorizationManagerConfig> getConfigurationType()
    {
        return ${pluginName}AuthorizationManagerConfig.class;
    }

    @Override
    public @Nullable Class<? extends GraphQLAuthorizationManager> getGraphQLAuthorizationManager()
    {
        return ${pluginName}GraphQLAuthorizationManager.class;
    }

    @Override
    public @Nullable Class<? extends OAuthAuthorizationManager> getOAuthAuthorizationManager()
    {
        return ${pluginName}OAuthAuthorizationManager.class;
    }

    @Override
    public @Nullable Class<? extends ScimAuthorizationManager> getScimAuthorizationManager()
    {
        return ${pluginName}ScimAuthorizationManager.class;
    }
}
