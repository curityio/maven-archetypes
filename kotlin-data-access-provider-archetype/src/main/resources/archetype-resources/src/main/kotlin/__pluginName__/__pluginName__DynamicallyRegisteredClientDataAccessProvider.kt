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
        throw UnsupportedOperationException()
    }

    override fun create(dynamicallyRegisteredClientAttributes: DynamicallyRegisteredClientAttributes)
    {
        _logger.debug("Received request to CREATE dynamic client with id : {}", dynamicallyRegisteredClientAttributes.clientId)
        throw UnsupportedOperationException()
    }

    override fun update(dynamicallyRegisteredClientAttributes: DynamicallyRegisteredClientAttributes)
    {
        _logger.debug("Received request to UPDATE dynamic client for client : {}", dynamicallyRegisteredClientAttributes.clientId)
        throw UnsupportedOperationException()
    }

    override fun delete(clientId: String)
    {
        _logger.debug("Received request to DELETE dynamic client : {}", clientId)
        throw UnsupportedOperationException()
    }

    companion object
    {
        private val _logger: Logger = LoggerFactory.getLogger(${pluginName}CredentialDataAccessProvider::class.java)
    }
}
