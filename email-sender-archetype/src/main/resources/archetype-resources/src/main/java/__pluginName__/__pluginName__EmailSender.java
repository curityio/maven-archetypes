package ${package}.${pluginName};

import se.curity.identityserver.sdk.data.email.RenderableEmail;
import se.curity.identityserver.sdk.email.Emailer;

public final class ${pluginName}EmailSender implements Emailer {

    private final ${pluginName}EmailProviderConfig _configuration;

    public ${pluginName}EmailSender(${pluginName}EmailProviderConfig configuration) {
        _configuration = configuration;
    }

    @Override
    public void sendEmail(RenderableEmail renderableEmail, String recipient)
    {
        // TODO: Implement sending an email.
        // Check out the examples on GitHub: https://github.com/search?q=email+org%3Acurityio&type=Repositories
    }
}
