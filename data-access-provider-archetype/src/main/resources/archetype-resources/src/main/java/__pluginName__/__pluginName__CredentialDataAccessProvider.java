package ${package}.${pluginName};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.curity.identityserver.sdk.Nullable;
import se.curity.identityserver.sdk.attribute.AccountAttributes;
import se.curity.identityserver.sdk.attribute.AuthenticationAttributes;
import se.curity.identityserver.sdk.datasource.CredentialDataAccessProvider;

public class ${pluginName}CredentialDataAccessProvider implements CredentialDataAccessProvider
{
    private static final Logger _logger = LoggerFactory.getLogger(${pluginName}CredentialDataAccessProvider.class);

    private final ${pluginName}DataAccessProviderConfig _configuration;

    @SuppressWarnings("unused") // used through DI
    public ${pluginName}CredentialDataAccessProvider(${pluginName}DataAccessProviderConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public void updatePassword(AccountAttributes accountAttributes)
    {
        _logger.debug("Received request to update password for username : {}", accountAttributes.getUserName());
        throw new UnsupportedOperationException();
    }

    @Override
    @Nullable
    public AuthenticationAttributes verifyPassword(String userName, String password)
    {
        _logger.debug("Received request to verify password for username : {}", userName);

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean customQueryVerifiesPassword()
    {
        throw new UnsupportedOperationException();
    }
}
