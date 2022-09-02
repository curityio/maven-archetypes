package ${package}.${pluginName}

import se.curity.identityserver.sdk.attribute.ContextAttributes
import se.curity.identityserver.sdk.attribute.SubjectAttributes
import se.curity.identityserver.sdk.authorization.GraphQLObligation
import se.curity.identityserver.sdk.authorization.AuthorizationResult
import se.curity.identityserver.sdk.authorization.graphql.GraphQLAuthorizationActionAttributes
import se.curity.identityserver.sdk.authorization.graphql.GraphQLAuthorizationManager
import se.curity.identityserver.sdk.authorization.graphql.GraphQLAuthorizationResourceAttributes

class ${pluginName}GraphQLAuthorizationManager(private val _configuration: ${pluginName}AuthorizationManagerConfig): GraphQLAuthorizationManager
{
    override fun getGraphQLAuthorizationResult(subjectAttributes: SubjectAttributes,
                                               graphQLAuthorizationActionAttributes: GraphQLAuthorizationActionAttributes,
                                               graphQLAuthorizationResourceAttributes: GraphQLAuthorizationResourceAttributes,
                                               contextAttributes: ContextAttributes)
        : AuthorizationResult<GraphQLObligation>
    {
        // TODO: Perform decision and return appropriate AuthorizationResult
        TODO("Not implemented")
    }
}
