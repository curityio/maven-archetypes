package ${package}.${pluginName}

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import se.curity.identityserver.sdk.attribute.AccountAttributes
import se.curity.identityserver.sdk.attribute.AuthenticationAttributes
import se.curity.identityserver.sdk.datasource.CredentialDataAccessProvider

class ${pluginName}CredentialDataAccessProvider(private val _configuration: ${pluginName}DataAccessProviderConfig): CredentialDataAccessProvider
{
    override fun updatePassword(accountAttributes: AccountAttributes )
    {
        _logger.debug("Received request to update password for username : {}", accountAttributes.userName)
        throw UnsupportedOperationException()
    }

    override fun verifyPassword(userName: String, password: String): AuthenticationAttributes?
    {
        _logger.debug("Received request to verify password for username : {}", userName)

        throw UnsupportedOperationException()
    }

    override fun customQueryVerifiesPassword(): Boolean
    {
        throw UnsupportedOperationException()
    }

    companion object
    {
        private val _logger: Logger = LoggerFactory.getLogger(${pluginName}CredentialDataAccessProvider::class.java)
    }
}
