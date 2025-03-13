package ${package}.${pluginName}

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import se.curity.identityserver.sdk.attribute.AccountAttributes
import se.curity.identityserver.sdk.attribute.AuthenticationAttributes
import se.curity.identityserver.sdk.datasource.CredentialDataAccessProviderFactory
import se.curity.identityserver.sdk.datasource.CredentialStoringDataAccessProvider

class ${pluginName}CredentialStoringDataAccessProvider(private val _configuration: ${pluginName}DataAccessProviderConfig): CredentialStoringDataAccessProvider, CredentialDataAccessProviderFactory
{

    @Nullable
    override fun get(subjectAttributes: SubjectAttributes): GetResult? {
        _logger.debug("Received request to update password for user : {}", subjectAttributes.subject)

        TODO()
    }

    override fun delete(subjectAttributes: SubjectAttributes): Boolean {
        _logger.debug("Received request to delete credentials for user: {}", subjectAttributes.subject)

        TODO()
    }

    override fun store(subjectAttributes: SubjectAttributes, password: String?): void {
        _logger.debug("Received request to store password for user : {}", subjectAttributes.subject)

        TODO()
    }

    companion object
    {
        private val _logger: Logger = LoggerFactory.getLogger(${pluginName}CredentialDataAccessProvider::class.java)
    }
}
