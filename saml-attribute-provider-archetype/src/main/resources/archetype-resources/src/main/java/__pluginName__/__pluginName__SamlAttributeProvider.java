package ${package}.${pluginName};

import se.curity.identityserver.sdk.attribute.Attributes;
import se.curity.identityserver.sdk.attribute.AuthenticationAttributes;
import se.curity.identityserver.sdk.saml.SamlAttributeProvider;
import se.curity.identityserver.sdk.saml.RequestedSamlAttribute;
import se.curity.identityserver.sdk.saml.SamlServiceProvider;

import java.util.Set;

public final class ${pluginName}SamlAttributeProvider implements SamlAttributeProvider
{
    private final ${pluginName}SamlAttributeProviderConfig _configuration;

    public ${pluginName}SamlAttributeProvider(${pluginName}SamlAttributeProviderConfig configuration)
    {
        _configuration = configuration;

        /**
         * SAML attribute provider behave similarly to claims providers. You can see
         * examples of claims providers on our GitHub: https://github.com/search?q=topic%3Aclaims-provider+org%3Acurityio
         */
    }

    @Override
    public Attributes getAttributeValues(Set<RequestedSamlAttribute> requestedSamlAttributes,
                                     AuthenticationAttributes userAuthenticationAttributes,
                                     SamlServiceProvider serviveProvider)
    {
        throw new UnsupportedOperationException();
    }
}
