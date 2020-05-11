package ${package}.${pluginName};

import se.curity.identityserver.sdk.oauth.consent.SigningConsentorResult;
import se.curity.identityserver.sdk.oauth.consent.signing.SigningConsentor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public final class ${pluginName}SigningConsentor implements SigningConsentor
{
    private final ${pluginName}ConsentorConfig _configuration;

    public ${pluginName}SigningConsentor(${pluginName}ConsentorConfig configuration) {
        _configuration = configuration;

        // See examples of consentors on GitHub: https://github.com/search?q=topic%3Aconsentor+org%3Acurityio
    }

    @Override
    public SigningConsentorResult start(String textToDisplay, String objectToSign)
    {
        throw new NotImplementedException();
    }

    @Override
    public SigningConsentorResult poll()
    {
        throw new NotImplementedException();
    }

    @Override
    public void cancel()
    {
        throw new NotImplementedException();
    }
}
