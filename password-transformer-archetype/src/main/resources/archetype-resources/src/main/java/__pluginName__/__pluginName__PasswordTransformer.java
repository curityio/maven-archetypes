package ${package}.${pluginName};

import se.curity.identityserver.sdk.service.credential.PasswordTransformer;

public final class ${pluginName}PasswordTransformer implements PasswordTransformer
{
    private final ${pluginName}PasswordTransformerConfig _configuration;

    public ${pluginName}PasswordTransformer(${pluginName}PasswordTransformerConfig configuration)
    {
        // A new instance may be created for each credential verification, so avoid expensive work here.
        // Keep state shared between verifications (e.g. caches) in a ManagedObject.
        _configuration = configuration;
    }

    @Override
    public String transform(String subject, CharSequence providedPassword)
    {
        // TODO: Hash the password with the current settings and return the value to store. Encode the settings
        // (e.g. salt and cost parameters) in the returned value, so that match() can read them back.
        // Do not retain the password or copy it into a String. Read it into a char[] or byte[] and clear that array.
        // See the interface's JavaDoc or https://curity.io/docs/idsvr-java-plugin-sdk/latest/se/curity/identityserver/sdk/service/credential/PasswordTransformer.html for more details.
        throw new UnsupportedOperationException();
    }

    @Override
    public MatchResult match(String subject, CharSequence providedPassword, String transformedPassword)
    {
        // TODO: Verify the password against the stored value, in fixed time.
        // The stored value is untrusted input: bound every setting read from it before use. Do not throw if it cannot
        // be used by this algorithm, return new MatchResult.NoMatch(true) instead.
        // Return new MatchResult.Match(true) if the provided password mathes the stored one, but the stored settings are outdated and the password should be rehashed.
        // See the interface's JavaDoc or https://curity.io/docs/idsvr-java-plugin-sdk/latest/se/curity/identityserver/sdk/service/credential/PasswordTransformer.html for more details.
        throw new UnsupportedOperationException();
    }
}
