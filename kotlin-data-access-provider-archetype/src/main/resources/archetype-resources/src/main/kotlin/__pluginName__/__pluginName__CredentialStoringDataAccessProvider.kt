package ${package}.${pluginName}

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import se.curity.identityserver.sdk.Nullable
import se.curity.identityserver.sdk.attribute.SubjectAttributes
import se.curity.identityserver.sdk.datasource.CredentialDataAccessProviderFactory
import se.curity.identityserver.sdk.datasource.CredentialStoringDataAccessProvider
import se.curity.identityserver.sdk.datasource.CredentialStoringDataAccessProvider.GetResult

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

    override fun store(subjectAttributes: SubjectAttributes, password: String?) {
        _logger.debug("Received request to store password for user : {}", subjectAttributes.subject)

        TODO()
    }

    companion object
    {
        private val _logger: Logger = LoggerFactory.getLogger(${pluginName}CredentialStoringDataAccessProvider::class.java)
    }
}
