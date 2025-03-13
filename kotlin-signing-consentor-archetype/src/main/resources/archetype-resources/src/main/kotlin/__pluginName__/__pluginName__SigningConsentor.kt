package ${package}.${pluginName}

import se.curity.identityserver.sdk.attribute.ConsentAttributes
import se.curity.identityserver.sdk.oauth.consent.SigningConsentorResult
import se.curity.identityserver.sdk.oauth.consent.signing.SigningConsentor

class ${pluginName}SigningConsentor(private val _configuration: ${pluginName}ConsentorConfig): SigningConsentor
{
    @Deprecated("Use the implementation with consentAttributes instead")
    override fun start(textToDisplay: String, objectToSign: String): SigningConsentorResult
    {
        TODO()
    }

    override fun start(textToDisplay: String, objectToSign: String, consentAttributes: ConsentAttributes): SigningConsentorResult
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
