package ${package}.${pluginName}

import se.curity.identityserver.sdk.data.email.RenderableEmail
import se.curity.identityserver.sdk.email.Emailer

class ${pluginName}EmailSender(private val _configuration: ${pluginName}EmailProviderConfig): Emailer
{
    override fun sendEmail(renderableEmail: RenderableEmail, recipient: String)
    {
        // TODO: Implement sending an email.
        // Check out the examples on GitHub: https://github.com/search?q=email+org%3Acurityio&type=Repositories
    }
}
