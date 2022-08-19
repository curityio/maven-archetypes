package ${package}.${pluginName};

import se.curity.identityserver.sdk.Nullable;
import se.curity.identityserver.sdk.authorization.graphql.GraphQLAuthorizationManager;
import se.curity.identityserver.sdk.authorization.oauth.OAuthAuthorizationManager;
import se.curity.identityserver.sdk.authorization.scim.ScimAuthorizationManager;
import se.curity.identityserver.sdk.plugin.descriptor.AuthorizationManagerPluginDescriptor;

class ${pluginName}AuthorizationManagerDescriptor: AuthorizationManagerPluginDescriptor<${pluginName}AuthorizationManagerConfig>
{
    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}AuthorizationManagerConfig::class.java

    override fun getGraphQLAuthorizationManager() = ${pluginName}GraphQLAuthorizationManager::class.java

    override fun getOAuthAuthorizationManager() = ${pluginName}OAuthAuthorizationManager::class.java

    override fun getScimAuthorizationManager() = ${pluginName}ScimAuthorizationManager::class.java
}
