package ${package}.${pluginName}

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import se.curity.identityserver.sdk.attribute.AccountAttributes
import se.curity.identityserver.sdk.attribute.scim.v2.ResourceAttributes
import se.curity.identityserver.sdk.attribute.scim.v2.extensions.LinkedAccount
import se.curity.identityserver.sdk.data.query.ResourceQuery
import se.curity.identityserver.sdk.data.query.ResourceQueryResult
import se.curity.identityserver.sdk.data.update.AttributeUpdate
import se.curity.identityserver.sdk.datasource.UserAccountDataAccessProvider

class ${pluginName}UserAccountDataAccessProvider(private val _configuration: ${pluginName}DataAccessProviderConfig): UserAccountDataAccessProvider
{
    override fun getByUserName(userName: String, attributesEnumeration: ResourceQuery.AttributesEnumeration): ResourceAttributes<*>
    {
        _logger.debug("Received request to get account by username : {}", userName)
        TODO()
    }

    override fun getByEmail(email: String, attributesEnumeration: ResourceQuery.AttributesEnumeration): ResourceAttributes<*>
    {
        _logger.debug("Received request to get account by email : {}", email)
        TODO()
    }

    override fun getByPhone(phone: String, attributesEnumeration: ResourceQuery.AttributesEnumeration): ResourceAttributes<*>
    {
        _logger.debug("Received request to get account by phone number : {}", phone)
        TODO()
    }

    override fun create(accountAttributes: AccountAttributes): AccountAttributes
    {
        _logger.debug("Received request to create account with data : {}", accountAttributes)
        TODO()
    }

    override fun update(accountAttributes: AccountAttributes,
                                        attributesEnumeration: ResourceQuery.AttributesEnumeration): ResourceAttributes<*>
    {
        _logger.debug("Received request to update account with data : {}", accountAttributes)
        TODO()
    }

    override fun update(accountId: String, map: Map<String, Any>,
                                        attributesEnumeration: ResourceQuery.AttributesEnumeration): ResourceAttributes<*>
    {
        _logger.debug("Received request to update account with id:{} and data : {}", accountId, map)
        TODO()
    }

    override fun patch(accountId: String, attributeUpdate: AttributeUpdate,
                                            attributesEnumeration: ResourceQuery.AttributesEnumeration): ResourceAttributes<*>
    {
        _logger.debug("Received patch request with accountId:{} and data : {}", accountId, attributeUpdate)
        TODO()
    }

    override fun link(linkingAccountManager: String, localAccountId: String, foreignDomainName: String, foreignUserName: String)
    {
        TODO()
    }

    override fun listLinks(linkingAccountManager: String, localAccountId: String): Collection<LinkedAccount>
    {
        TODO()
    }

    override fun resolveLink(linkingAccountManager: String, foreignDomainName: String, foreignAccountId: String): AccountAttributes
    {
        TODO()
    }

    override fun deleteLink(linkingAccountManager: String, localAccountId: String, foreignDomainName: String, foreignAccountId: String): Boolean
    {
        TODO()
    }

    override fun delete(accountId: String)
    {
        _logger.debug("Received request to delete account with accountId: {}", accountId)
        TODO()
    }

    override fun getAll(startIndex: Long, count: Long): ResourceQueryResult
    {
        _logger.debug("Received request to get all accounts with startIndex :{} and count: {}", startIndex, count)
        TODO()
    }

    companion object
    {
        private val _logger: Logger = LoggerFactory.getLogger(${pluginName}UserAccountDataAccessProvider::class.java)
    }
}
