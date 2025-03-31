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
        TODO()
    }

    override fun getBy(deviceId: String, accountId: String,
                                        attributesEnumeration: ResourceQuery.AttributesEnumeration): ResourceAttributes<*>
    {
        _logger.debug("Received request to get device by deviceId :{} and accountId: {}", deviceId, accountId)
        TODO()
    }

    override fun getById(deviceId: String): DeviceAttributes
    {
        _logger.debug("Received request to get device by deviceId :{}", deviceId)
        TODO()
    }

    override fun getById(deviceId: String, attributesEnumeration: ResourceQuery.AttributesEnumeration): ResourceAttributes<*>
    {
        _logger.debug("Received request to get device by deviceId :{}", deviceId)
        TODO()
    }

    override fun getByAccountId(accountId: String): List<DeviceAttributes>
    {
        _logger.debug("Received request to get devices by accountId :{}", accountId)
        TODO()
    }

    override fun getByAccountId(accountId: String, attributesEnumeration: ResourceQuery.AttributesEnumeration): List<ResourceAttributes<*>>
    {
        _logger.debug("Received request to get devices by accountId :{}", accountId)
        TODO()
    }

    override fun create(deviceAttributes: DeviceAttributes)
    {
        _logger.debug("Received request to create device by deviceId :{}", deviceAttributes.deviceId)
        TODO()
    }

    override fun update(deviceAttributes: DeviceAttributes)
    {
        _logger.debug("Received request to update device by deviceId :{}", deviceAttributes.deviceId)
        TODO()
    }

    override fun delete(id: String)
    {
        _logger.debug("Received request to update device by id :{}", id)
        TODO()
    }

    override fun delete(deviceId: String, accountId: String)
    {
        _logger.debug("Received request to delete device by deviceId :{} and accountId: {}", deviceId, accountId)
        TODO()
    }

    override fun getAll(startIndex: Long, count: Long): ResourceQueryResult
    {
        _logger.debug("Received request to get all devices with startIndex :{} and count: {}", startIndex, count)
        TODO()
    }

    companion object
    {
        private val _logger: Logger = LoggerFactory.getLogger(${pluginName}DeviceDataAccessProvider::class.java)
    }
}
