package ${package}.${pluginName}

import se.curity.identityserver.sdk.oauth.consent.SigningConsentorResult
import se.curity.identityserver.sdk.oauth.consent.signing.SigningConsentor

class ${pluginName}SigningConsentor(private val _configuration: ${pluginName}ConsentorConfig): SigningConsentor
{
    override fun start(textToDisplay: String, objectToSign: String): SigningConsentorResult
    {
        TODO()
    }

    override fun poll(): SigningConsentorResult
    {
        TODO()
    }

    override fun cancel()
    {
        TODO()
    }
}
