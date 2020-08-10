package ${package}.${pluginName}

import se.curity.identityserver.sdk.oauth.consent.SigningConsentorResult
import se.curity.identityserver.sdk.oauth.consent.signing.SigningConsentor

class ${pluginName}SigningConsentor(private val _configuration: ${pluginName}ConsentorConfig): SigningConsentor
{
    override fun start(textToDisplay: String, objectToSign: String): SigningConsentorResult
    {
        throw UnsupportedOperationException()
    }

    override fun poll(): SigningConsentorResult
    {
        throw UnsupportedOperationException()
    }

    override fun cancel()
    {
        throw UnsupportedOperationException()
    }
}
