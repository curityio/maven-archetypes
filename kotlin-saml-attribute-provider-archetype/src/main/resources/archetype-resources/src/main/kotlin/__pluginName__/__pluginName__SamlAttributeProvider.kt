package ${package}.${pluginName}

import se.curity.identityserver.sdk.attribute.Attributes
import se.curity.identityserver.sdk.attribute.AuthenticationAttributes
import se.curity.identityserver.sdk.saml.SamlAttributeProvider
import se.curity.identityserver.sdk.saml.RequestedSamlAttribute
import se.curity.identityserver.sdk.saml.SamlServiceProvider

class ${pluginName}SamlAttributeProvider(private val _configuration: ${pluginName}SamlAttributeProviderConfig): SamlAttributeProvider
{
    /**
     * SAML attribute provider behave similarly to claims providers. You can see
     * examples of claims providers on our GitHub: https://github.com/search?q=topic%3Aclaims-provider+org%3Acurityio
     */

    override fun getAttributeValues(requestedSamlAttributes: Set<RequestedSamlAttribute>,
                                userAuthenticationAttributes: AuthenticationAttributes,
                                serviceProvider: SamlServiceProvider): Attributes
    {
        TODO()
    }
}
