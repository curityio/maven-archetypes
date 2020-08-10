package ${package}.${pluginName}

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import se.curity.identityserver.sdk.attribute.scim.v2.ResourceAttributes
import se.curity.identityserver.sdk.attribute.scim.v2.extensions.DeviceAttributes
import se.curity.identityserver.sdk.data.query.ResourceQuery
import se.curity.identityserver.sdk.data.query.ResourceQueryResult
import se.curity.identityserver.sdk.datasource.DeviceDataAccessProvider

class ${pluginName}DeviceDataAccessProvider(private val _configuration: ${pluginName}DataAccessProviderConfig): DeviceDataAccessProvider
{

    override fun getBy(deviceId: String, accountId: String): DeviceAttributes
    {
        _logger.debug("Received request to get device by deviceId :{} and accountId: {}", deviceId, accountId)
        throw UnsupportedOperationException()
    }

    override fun getBy(deviceId: String, accountId: String,
                                        attributesEnumeration: ResourceQuery.AttributesEnumeration): ResourceAttributes<*>
    {
        _logger.debug("Received request to get device by deviceId :{} and accountId: {}", deviceId, accountId)
        throw UnsupportedOperationException()
    }

    override fun getById(deviceId: String): DeviceAttributes
    {
        _logger.debug("Received request to get device by deviceId :{}", deviceId)
        throw UnsupportedOperationException()
    }

    override fun getById(deviceId: String, attributesEnumeration: ResourceQuery.AttributesEnumeration): ResourceAttributes<*>
    {
        _logger.debug("Received request to get device by deviceId :{}", deviceId)
        throw UnsupportedOperationException()
    }

    override fun getByAccountId(accountId: String): List<DeviceAttributes>
    {
        _logger.debug("Received request to get devices by accountId :{}", accountId)
        throw UnsupportedOperationException()
    }

    override fun getByAccountId(accountId: String, attributesEnumeration: ResourceQuery.AttributesEnumeration): List<ResourceAttributes<*>>
    {
        _logger.debug("Received request to get devices by accountId :{}", accountId)
        throw UnsupportedOperationException()
    }

    override fun create(deviceAttributes: DeviceAttributes)
    {
        _logger.debug("Received request to create device by deviceId :{}", deviceAttributes.deviceId)
        throw UnsupportedOperationException()
    }

    override fun update(deviceAttributes: DeviceAttributes)
    {
        _logger.debug("Received request to update device by deviceId :{}", deviceAttributes.deviceId)
        throw UnsupportedOperationException()
    }

    override fun delete(id: String)
    {
        _logger.debug("Received request to update device by id :{}", id)
        throw UnsupportedOperationException()
    }

    override fun delete(deviceId: String, accountId: String)
    {
        _logger.debug("Received request to delete device by deviceId :{} and accountId: {}", deviceId, accountId)
        throw UnsupportedOperationException()
    }

    override fun getAll(startIndex: Long, count: Long): ResourceQueryResult
    {
        _logger.debug("Received request to get all devices with startIndex :{} and count: {}", startIndex, count)
        throw UnsupportedOperationException()
    }

    companion object
    {
        private val _logger: Logger = LoggerFactory.getLogger(${pluginName}CredentialDataAccessProvider::class.java)
    }
}
