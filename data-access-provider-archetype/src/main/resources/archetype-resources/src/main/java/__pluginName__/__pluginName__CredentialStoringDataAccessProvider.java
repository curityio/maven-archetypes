package ${package}.${pluginName};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.curity.identityserver.sdk.Nullable;
import se.curity.identityserver.sdk.attribute.SubjectAttributes;
import se.curity.identityserver.sdk.datasource.CredentialDataAccessProviderFactory;
import se.curity.identityserver.sdk.datasource.CredentialStoringDataAccessProvider;

public final class ${pluginName}CredentialStoringDataAccessProvider implements CredentialStoringDataAccessProvider, CredentialDataAccessProviderFactory
{
    private static final Logger _logger = LoggerFactory.getLogger(${pluginName}CredentialDataAccessProvider.class);

    private final ${pluginName}DataAccessProviderConfig _configuration;

    @SuppressWarnings("unused") // used through DI
    public ${pluginName}CredentialStoringDataAccessProvider(${pluginName}DataAccessProviderConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    @Nullable
    public GetResult get(SubjectAttributes subjectAttributes)
    {
        _logger.debug("Received request to retrieve a credential for a given subject: {}", subjectAttributes.getSubject());

        throw new UnsupportedOperationException();
    }

    @Override
    public void store(SubjectAttributes subjectAttributes, String password)
    {
        _logger.debug("Received request to store password for user: {}", subjectAttributes.getSubject());
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(SubjectAttributes subjectAttributes) {
        _logger.debug("Received request to delete credentials for user: {}", subjectAttributes.getSubject());

        throw new UnsupportedOperationException();
    }
}
