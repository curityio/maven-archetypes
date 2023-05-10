package ${package}.${pluginName}

import se.curity.identityserver.sdk.config.Configuration
import se.curity.identityserver.sdk.config.annotation.DefaultService
import se.curity.identityserver.sdk.config.annotation.Description
import se.curity.identityserver.sdk.service.issuer.AccessTokenIssuer
import se.curity.identityserver.sdk.service.issuer.IdTokenIssuer
import se.curity.identityserver.sdk.service.issuer.NonceIssuer
import se.curity.identityserver.sdk.service.issuer.RefreshTokenIssuer

interface ${pluginName}TokenProcedureConfig: Configuration
{
    @Description("A parameter used for demo purposes")
    fun getDemoParameter(): Int

    @DefaultService
    fun getAccessTokenIssuer(): AccessTokenIssuer

    @DefaultService
    fun getRefreshTokenIssuer(): RefreshTokenIssuer

    @DefaultService
    fun getIdTokenIssuer(): IdTokenIssuer

    @DefaultService
    fun getAuthorizationCodeIssuer(): NonceIssuer
}
