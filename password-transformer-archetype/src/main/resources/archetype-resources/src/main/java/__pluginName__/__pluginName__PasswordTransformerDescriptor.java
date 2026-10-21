package ${package}.${pluginName};

import se.curity.identityserver.sdk.plugin.descriptor.PasswordTransformerPluginDescriptor;
import se.curity.identityserver.sdk.service.credential.PasswordTransformer;

import java.util.Map;

public final class ${pluginName}PasswordTransformerDescriptor implements PasswordTransformerPluginDescriptor<${pluginName}PasswordTransformerConfig>
{
    @Override
    public Map<String, Class<? extends PasswordTransformer>> getPasswordTransformers()
    {
        // TODO: Change the algorithm name to the simple name of your hashing algorithm.
        // A plugin can provide a family of algorithms (e.g. argon2id, argon2i and argon2d) by returning more entries.
        // Each name must be a valid YANG identifier and unique across all installed password transformer plugins.
        return Map.of("${pluginName.toLowerCase()}", ${pluginName}PasswordTransformer.class);
    }

    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}PasswordTransformerConfig> getConfigurationType()
    {
        return ${pluginName}PasswordTransformerConfig.class;
    }
}
