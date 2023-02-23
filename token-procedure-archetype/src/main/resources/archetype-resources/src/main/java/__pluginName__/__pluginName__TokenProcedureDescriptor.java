package ${package}.${pluginName};

import se.curity.identityserver.sdk.plugin.descriptor.TokenProcedurePluginDescriptor;
import se.curity.identityserver.sdk.procedure.token.AssertionTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.AssistedTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.AuthorizationCodeTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.AuthorizeCodeTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.AuthorizeImplicitTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.BackchannelAuthenticationTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.ClientCredentialsTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.DeviceAuthorizationTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.DeviceCodeTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.IntrospectionApplicationJwtTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.IntrospectionTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.OpenIdAuthorizeEndpointHybridTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.OpenIdUserInfoTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.RefreshTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.RopcTokenProcedure;
import se.curity.identityserver.sdk.procedure.token.TokenExchangeTokenProcedure;

public final class ${pluginName}TokenProcedureDescriptor implements TokenProcedurePluginDescriptor<${pluginName}TokenProcedureConfig>
{
    @Override
    public Class<? extends RefreshTokenProcedure> getOAuthTokenEndpointRefreshTokenProcedure()
    {
        return ${pluginName}RefreshTokenProcedure.class;
    }

    @Override
    public Class<? extends AuthorizeCodeTokenProcedure> getOAuthAuthorizeEndpointCodeTokenProcedure()
    {
        return ${pluginName}AuthorizeCodeTokenProcedure.class;
    }

    @Override
    public Class<? extends AuthorizeImplicitTokenProcedure> getOAuthAuthorizeEndpointImplicitTokenProcedure()
    {
        return ${pluginName}AuthorizeImplicitTokenProcedure.class;
    }

    @Override
    public Class<? extends DeviceAuthorizationTokenProcedure> getOAuthDeviceAuthorizationTokenProcedure()
    {
        return ${pluginName}DeviceAuthorizationTokenProcedure.class;
    }

    @Override
    public Class<? extends IntrospectionApplicationJwtTokenProcedure> getOAuthIntrospectApplicationJwtTokenProcedure()
    {
        return ${pluginName}IntrospectionApplicationJwtTokenProcedure.class;
    }

    @Override
    public Class<? extends AssertionTokenProcedure> getOAuthTokenEndpointAssertionTokenProcedure()
    {
        return ${pluginName}AssertionTokenProcedure.class;
    }

    @Override
    public Class<? extends AuthorizationCodeTokenProcedure> getOAuthTokenEndpointAuthorizationCodeTokenProcedure()
    {
        return ${pluginName}AuthorizationCodeTokenProcedure.class;
    }

    @Override
    public Class<? extends IntrospectionTokenProcedure> getOAuthIntrospectTokenProcedure()
    {
        return ${pluginName}IntrospectionTokenProcedure.class;
    }

    @Override
    public Class<? extends BackchannelAuthenticationTokenProcedure> getOAuthTokenEndpointBackchannelAuthenticationTokenProcedure()
    {
        return ${pluginName}BackchannelAuthenticationTokenProcedure.class;
    }

    @Override
    public Class<? extends ClientCredentialsTokenProcedure> getOAuthTokenEndpointClientCredentialsTokenProcedure()
    {
        return ${pluginName}ClientCredentialsTokenProcedure.class;
    }

    @Override
    public Class<? extends DeviceCodeTokenProcedure> getOAuthTokenEndpointDeviceCodeTokenProcedure()
    {
        return ${pluginName}DeviceCodeTokenProcedure.class;
    }

    @Override
    public Class<? extends RopcTokenProcedure> getOAuthTokenEndpointRopcTokenProcedure()
    {
        return ${pluginName}RopcTokenProcedure.class;
    }

    @Override
    public Class<? extends TokenExchangeTokenProcedure> getOAuthTokenEndpointTokenExchangeTokenProcedure()
    {
        return ${pluginName}TokenExchangeTokenProcedure.class;
    }

    @Override
    public Class<? extends OpenIdAuthorizeEndpointHybridTokenProcedure> getOpenIdAuthorizeEndpointHybridTokenProcedure()
    {
        return ${pluginName}OpenIdAuthorizeEndpointHybridTokenProcedure.class;
    }

    @Override
    public Class<? extends OpenIdUserInfoTokenProcedure> getOpenIdUserInfoTokenProcedure()
    {
        return ${pluginName}OpenIdUserInfoTokenProcedure.class;
    }

    @Override
    public Class<? extends AssistedTokenProcedure> getOAuthAssistedTokenTokenProcedure()
    {
        return ${pluginName}AssistedTokenProcedure.class;
    }
    
    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}TokenProcedureConfig> getConfigurationType()
    {
        return ${pluginName}TokenProcedureConfig.class;
    }    
}
