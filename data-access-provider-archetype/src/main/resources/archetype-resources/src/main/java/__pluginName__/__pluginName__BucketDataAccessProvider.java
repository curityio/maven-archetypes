package ${package}.${pluginName};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.curity.identityserver.sdk.datasource.BucketDataAccessProvider;

import java.util.Map;

public final class ${pluginName}BucketDataAccessProvider implements BucketDataAccessProvider
{
    private static final Logger _logger = LoggerFactory.getLogger(${pluginName}BucketDataAccessProvider.class);

    private final ${pluginName}DataAccessProviderConfig _configuration;

    @SuppressWarnings("unused") // used through DI
    public ${pluginName}BucketDataAccessProvider(${pluginName}DataAccessProviderConfig configuration)
    {
        _configuration = configuration;
    }

    @Override
    public Map<String, Object> getAttributes(String subject, String purpose)
    {
        _logger.debug("Getting bucket attributes with subject: {} , purpose : {}", subject, purpose);
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<String, Object> storeAttributes(String subject, String purpose, Map<String, Object> dataMap)
    {
        dataMap.put("subject", subject);
        dataMap.put("purpose", purpose);

        _logger.debug("Storing bucket attributes with subject: {} , purpose : {} and data : {}", subject, purpose, dataMap);

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean clearBucket(String subject, String purpose)
    {
        throw new UnsupportedOperationException();
    }
}
