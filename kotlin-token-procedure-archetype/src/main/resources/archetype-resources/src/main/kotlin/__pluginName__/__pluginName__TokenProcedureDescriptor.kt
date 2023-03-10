package ${package}.${pluginName}

import se.curity.identityserver.sdk.plugin.descriptor.TokenProcedurePluginDescriptor
import se.curity.identityserver.sdk.procedure.token.AssertionTokenProcedure
import se.curity.identityserver.sdk.procedure.token.AssistedTokenProcedure
import se.curity.identityserver.sdk.procedure.token.AuthorizationCodeTokenProcedure
import se.curity.identityserver.sdk.procedure.token.AuthorizeCodeTokenProcedure
import se.curity.identityserver.sdk.procedure.token.AuthorizeImplicitTokenProcedure
import se.curity.identityserver.sdk.procedure.token.BackchannelAuthenticationTokenProcedure
import se.curity.identityserver.sdk.procedure.token.ClientCredentialsTokenProcedure
import se.curity.identityserver.sdk.procedure.token.DeviceAuthorizationTokenProcedure
import se.curity.identityserver.sdk.procedure.token.DeviceCodeTokenProcedure
import se.curity.identityserver.sdk.procedure.token.IntrospectionApplicationJwtTokenProcedure
import se.curity.identityserver.sdk.procedure.token.IntrospectionTokenProcedure
import se.curity.identityserver.sdk.procedure.token.OpenIdAuthorizeEndpointHybridTokenProcedure
import se.curity.identityserver.sdk.procedure.token.OpenIdUserInfoTokenProcedure
import se.curity.identityserver.sdk.procedure.token.RefreshTokenProcedure
import se.curity.identityserver.sdk.procedure.token.RopcTokenProcedure
import se.curity.identityserver.sdk.procedure.token.TokenExchangeTokenProcedure

class ${pluginName}TokenProcedureDescriptor: TokenProcedurePluginDescriptor<${pluginName}TokenProcedureConfig>
{
    override fun getOAuthTokenEndpointRefreshTokenProcedure() = ${pluginName}RefreshTokenProcedure::class.java

    override fun getOAuthAuthorizeEndpointCodeTokenProcedure() = ${pluginName}AuthorizeCodeTokenProcedure::class.java

    override fun getOAuthAuthorizeEndpointImplicitTokenProcedure() = ${pluginName}AuthorizeImplicitTokenProcedure::class.java

    override fun getOAuthDeviceAuthorizationTokenProcedure() = ${pluginName}DeviceAuthorizationTokenProcedure::class.java

    override fun getOAuthIntrospectApplicationJwtTokenProcedure() = ${pluginName}IntrospectionApplicationJwtTokenProcedure::class.java

    override fun getOAuthTokenEndpointAssertionTokenProcedure() = ${pluginName}AssertionTokenProcedure::class.java

    override fun getOAuthTokenEndpointAuthorizationCodeTokenProcedure() = ${pluginName}AuthorizationCodeTokenProcedure::class.java

    override fun getOAuthIntrospectTokenProcedure() = ${pluginName}IntrospectionTokenProcedure::class.java

    override fun getOAuthTokenEndpointBackchannelAuthenticationTokenProcedure() = ${pluginName}BackchannelAuthenticationTokenProcedure::class.java

    override fun getOAuthTokenEndpointClientCredentialsTokenProcedure() = ${pluginName}ClientCredentialsTokenProcedure::class.java

    override fun getOAuthTokenEndpointDeviceCodeTokenProcedure() = ${pluginName}DeviceCodeTokenProcedure::class.java

    override fun getOAuthTokenEndpointRopcTokenProcedure() = ${pluginName}RopcTokenProcedure::class.java

    override fun getOAuthTokenEndpointTokenExchangeTokenProcedure() = ${pluginName}TokenExchangeTokenProcedure::class.java

    override fun getOpenIdAuthorizeEndpointHybridTokenProcedure() = ${pluginName}OpenIdAuthorizeEndpointHybridTokenProcedure::class.java

    override fun getOpenIdUserInfoTokenProcedure() = ${pluginName}OpenIdUserInfoTokenProcedure::class.java

    override fun getOAuthAssistedTokenTokenProcedure() = ${pluginName}AssistedTokenProcedure::class.java
    
    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}TokenProcedureConfig::class.java    
}
