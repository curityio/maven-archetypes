package ${package}.${pluginName}

import se.curity.identityserver.sdk.plugin.descriptor.PasswordTransformerPluginDescriptor
import se.curity.identityserver.sdk.service.credential.PasswordTransformer

class ${pluginName}PasswordTransformerDescriptor: PasswordTransformerPluginDescriptor<${pluginName}PasswordTransformerConfig>
{
    // TODO: Change the algorithm name to the simple name of your hashing algorithm. A plugin can provide a family
    // of algorithms (e.g. argon2id, argon2i and argon2d) by returning more entries. Each name must be a valid YANG
    // identifier and unique across all installed password transformer plugins.
    override fun getPasswordTransformers(): Map<String, Class<out PasswordTransformer>> =
        mapOf("${pluginName.toLowerCase()}" to ${pluginName}PasswordTransformer::class.java)

    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}PasswordTransformerConfig::class.java
}
