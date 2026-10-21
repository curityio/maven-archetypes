package ${package}.${pluginName}

import se.curity.identityserver.sdk.service.credential.PasswordTransformer
import se.curity.identityserver.sdk.service.credential.PasswordTransformer.MatchResult

// A new instance may be created for each credential verification, so avoid expensive work in the constructor.
// Keep state shared between verifications (e.g. caches) in a ManagedObject.
class ${pluginName}PasswordTransformer(private val _configuration: ${pluginName}PasswordTransformerConfig): PasswordTransformer
{
    override fun transform(subject: String, providedPassword: CharSequence): String
    {
        // TODO: Hash the password with the current settings and return the value to store. Encode the settings
        // (e.g. salt and cost parameters) in the returned value, so that match() can read them back.
        // Do not retain the password or copy it into a String. Read it into a CharArray or ByteArray and clear that array.
        // See the interface's JavaDoc or https://curity.io/docs/idsvr-java-plugin-sdk/latest/se/curity/identityserver/sdk/service/credential/PasswordTransformer.html for more details.
        TODO()
    }

    override fun match(subject: String, providedPassword: CharSequence, transformedPassword: String): MatchResult
    {
        // TODO: Verify the password against the stored value, in fixed time.
        // The stored value is untrusted input: bound every setting read from it before use.
        // Do not throw if it cannot be used by this algorithm, return MatchResult.NoMatch(true) instead.
        // Return MatchResult.Match(true) if the provided password matches the stored one, but the stored settings are outdated and the password should be rehashed.
        // See the interface's JavaDoc or https://curity.io/docs/idsvr-java-plugin-sdk/latest/se/curity/identityserver/sdk/service/credential/PasswordTransformer.html for more details.
        TODO()
    }
}
