package ${package}.${pluginName};

import se.curity.identityserver.sdk.attribute.ConsentAttributes;
import se.curity.identityserver.sdk.oauth.consent.ConsentorResult;
import se.curity.identityserver.sdk.oauth.consent.Consentor;

public final class ${pluginName}Consentor implements Consentor
{
    private final ${pluginName}ConsentorConfig _configuration;

    public ${pluginName}Consentor(${pluginName}ConsentorConfig configuration)
    {
        _configuration = configuration;

        // See examples of consentors on GitHub: https://github.com/search?q=topic%3Aconsentor+org%3Acurityio
    }

    @Override
    public ConsentorResult apply(ConsentAttributes consentAttributes, String transactionId)
    {
        throw new UnsupportedOperationException();
    }
}
