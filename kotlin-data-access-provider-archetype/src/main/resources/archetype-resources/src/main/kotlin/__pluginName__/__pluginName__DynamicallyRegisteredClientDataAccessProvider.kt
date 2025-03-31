package ${package}.${pluginName}

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import se.curity.identityserver.sdk.attribute.scim.v2.extensions.DynamicallyRegisteredClientAttributes
import se.curity.identityserver.sdk.datasource.DynamicallyRegisteredClientDataAccessProvider

class ${pluginName}DynamicallyRegisteredClientDataAccessProvider(private val _configuration: ${pluginName}DataAccessProviderConfig): DynamicallyRegisteredClientDataAccessProvider
{
    override fun getByClientId(clientId: String): DynamicallyRegisteredClientAttributes
    {
        _logger.debug("Getting dynamic client with id: {}", clientId)
        TODO()
    }

    override fun create(dynamicallyRegisteredClientAttributes: DynamicallyRegisteredClientAttributes)
    {
        _logger.debug("Received request to CREATE dynamic client with id : {}", dynamicallyRegisteredClientAttributes.clientId)
        TODO()
    }

    override fun update(dynamicallyRegisteredClientAttributes: DynamicallyRegisteredClientAttributes)
    {
        _logger.debug("Received request to UPDATE dynamic client for client : {}", dynamicallyRegisteredClientAttributes.clientId)
        TODO()
    }

    override fun delete(clientId: String)
    {
        _logger.debug("Received request to DELETE dynamic client : {}", clientId)
        TODO()
    }

    companion object
    {
        private val _logger: Logger = LoggerFactory.getLogger(${pluginName}DynamicallyRegisteredClientDataAccessProvider::class.java)
    }
}
