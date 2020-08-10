package ${package}.${pluginName}

import se.curity.identityserver.sdk.attribute.ConsentAttributes
import se.curity.identityserver.sdk.oauth.consent.ConsentorResult
import se.curity.identityserver.sdk.oauth.consent.Consentor

class ${pluginName}Consentor(private val _configuration: ${pluginName}ConsentorConfig): Consentor
{
    // See examples of consentors on GitHub: https://github.com/search?q=topic%3Aconsentor+org%3Acurityio

    override fun apply(consentAttributes: ConsentAttributes,transactionId: String): ConsentorResult
    {
        throw UnsupportedOperationException();
    }
}
