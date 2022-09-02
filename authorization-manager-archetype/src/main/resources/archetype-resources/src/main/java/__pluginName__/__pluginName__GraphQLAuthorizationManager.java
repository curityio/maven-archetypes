package ${package}.${pluginName};

import se.curity.identityserver.sdk.attribute.ContextAttributes;
import se.curity.identityserver.sdk.attribute.SubjectAttributes;
import se.curity.identityserver.sdk.authorization.AuthorizationResult;
import se.curity.identityserver.sdk.authorization.GraphQLObligation;
import se.curity.identityserver.sdk.authorization.graphql.GraphQLAuthorizationActionAttributes;
import se.curity.identityserver.sdk.authorization.graphql.GraphQLAuthorizationManager;
import se.curity.identityserver.sdk.authorization.graphql.GraphQLAuthorizationResourceAttributes;

public final class ${pluginName}GraphQLAuthorizationManager implements GraphQLAuthorizationManager
{
    private final ${pluginName}AuthorizationManagerConfig _configuration;

    public ${pluginName}GraphQLAuthorizationManager(${pluginName}AuthorizationManagerConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public AuthorizationResult<GraphQLObligation> getGraphQLAuthorizationResult(SubjectAttributes subjectAttributes,
                                                                                GraphQLAuthorizationActionAttributes graphQLAuthorizationActionAttributes,
                                                                                GraphQLAuthorizationResourceAttributes graphQLAuthorizationResourceAttributes,
                                                                                ContextAttributes contextAttributes)
    {
        // TODO: Perform decision and return appropriate AuthorizationResult
        return AuthorizationResult.notApplicable();
    }

}
