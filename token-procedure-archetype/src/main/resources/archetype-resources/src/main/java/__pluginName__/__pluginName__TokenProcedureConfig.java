package ${package}.${pluginName};

import se.curity.identityserver.sdk.config.Configuration;
import se.curity.identityserver.sdk.config.annotation.DefaultService;
import se.curity.identityserver.sdk.config.annotation.Description;
import se.curity.identityserver.sdk.service.issuer.AccessTokenIssuer;
import se.curity.identityserver.sdk.service.issuer.IdTokenIssuer;
import se.curity.identityserver.sdk.service.issuer.NonceIssuer;
import se.curity.identityserver.sdk.service.issuer.RefreshTokenIssuer;

public interface ${pluginName}TokenProcedureConfig extends Configuration
{
    @Description("A parameter used for demo purposes")
    Integer getDemoParameter();

    @DefaultService
    AccessTokenIssuer getAccessTokenIssuer();

    @DefaultService
    RefreshTokenIssuer getRefreshTokenIssuer();

    @DefaultService
    IdTokenIssuer getIdTokenIssuer();

    @DefaultService
    NonceIssuer getAuthorizationCodeIssuer();
}
