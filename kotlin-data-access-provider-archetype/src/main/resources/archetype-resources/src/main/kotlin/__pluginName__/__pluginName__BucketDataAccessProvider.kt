package ${package}.${pluginName}

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import se.curity.identityserver.sdk.datasource.BucketDataAccessProvider

class ${pluginName}BucketDataAccessProvider(private val _configuration: ${pluginName}DataAccessProviderConfig): BucketDataAccessProvider
{
    override fun getAttributes(subject: String, purpose: String): Map<String, Any>
    {
        _logger.debug("Getting bucket attributes with subject: {} , purpose : {}", subject, purpose)
        TODO()
    }

    override fun storeAttributes(subject: String, purpose: String, dataMap: MutableMap<String, Any>): Map<String, Any>
    {
        dataMap["subject"] = subject
        dataMap["purpose"] = purpose

        _logger.debug("Storing bucket attributes with subject: {} , purpose : {} and data : {}", subject, purpose, dataMap)

        TODO()
    }

    override fun clearBucket(subject: String, purpose: String): Boolean
    {
        TODO()
    }

    companion object
    {
        private val _logger: Logger = LoggerFactory.getLogger(${pluginName}BucketDataAccessProvider::class.java)
    }
}
