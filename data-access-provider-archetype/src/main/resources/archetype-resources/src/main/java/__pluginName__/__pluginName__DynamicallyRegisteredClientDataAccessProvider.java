package ${package}.${pluginName};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.curity.identityserver.sdk.attribute.scim.v2.extensions.DynamicallyRegisteredClientAttributes;
import se.curity.identityserver.sdk.datasource.DynamicallyRegisteredClientDataAccessProvider;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ${pluginName}DynamicallyRegisteredClientDataAccessProvider implements DynamicallyRegisteredClientDataAccessProvider
{
    private static final Logger _logger = LoggerFactory.getLogger(${pluginName}CredentialDataAccessProvider.class);

    private final ${pluginName}DataAccessProviderConfig _configuration;

    @SuppressWarnings("unused") // used through DI
    public ${pluginName}DynamicallyRegisteredClientDataAccessProvider(${pluginName}DataAccessProviderConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public DynamicallyRegisteredClientAttributes getByClientId(String clientId)
    {
        _logger.debug("Getting dynamic client with id: {}", clientId);
        throw new NotImplementedException();
    }

    @Override
    public void create(DynamicallyRegisteredClientAttributes dynamicallyRegisteredClientAttributes)
    {
        _logger.debug("Received request to CREATE dynamic client with id : {}",
        dynamicallyRegisteredClientAttributes.getClientId());
        throw new NotImplementedException();
    }

    @Override
    public void update(DynamicallyRegisteredClientAttributes dynamicallyRegisteredClientAttributes)
    {
        _logger.debug("Received request to UPDATE dynamic client for client : {}",
        dynamicallyRegisteredClientAttributes.getClientId());
        throw new NotImplementedException();
    }

    @Override
    public void delete(String clientId)
    {
        _logger.debug("Received request to DELETE dynamic client : {}", clientId);
        throw new NotImplementedException();
    }
}
