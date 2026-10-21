package ${package}.${pluginName};

import se.curity.identityserver.sdk.oauth.tokenissuanceauthorizers.TokenIssuanceAuthorizer;
import se.curity.identityserver.sdk.plugin.descriptor.TokenIssuanceAuthorizerPluginDescriptor;

public final class ${pluginName}TokenIssuanceAuthorizerDescriptor implements TokenIssuanceAuthorizerPluginDescriptor<${pluginName}TokenIssuanceAuthorizerConfig>
{
    @Override
    public Class<? extends TokenIssuanceAuthorizer> getTokenIssuanceAuthorizer()
    {
        return ${pluginName}TokenIssuanceAuthorizer.class;
    }

    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}TokenIssuanceAuthorizerConfig> getConfigurationType()
    {
        return ${pluginName}TokenIssuanceAuthorizerConfig.class;
    }
}
