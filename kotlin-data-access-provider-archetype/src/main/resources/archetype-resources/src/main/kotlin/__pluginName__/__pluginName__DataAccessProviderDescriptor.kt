package ${package}.${pluginName}

import se.curity.identityserver.sdk.plugin.descriptor.DataAccessProviderPluginDescriptor

class ${pluginName}DataAccessProviderDescriptor: DataAccessProviderPluginDescriptor<${pluginName}DataAccessProviderConfig>
{
    override fun getPluginImplementationType() = "${pluginName.toLowerCase()}"

    override fun getConfigurationType() = ${pluginName}DataAccessProviderConfig::class.java

    override fun getCredentialDataAccessProvider() = ${pluginName}CredentialDataAccessProvider::class.java

    override fun getUserAccountDataAccessProvider() = ${pluginName}UserAccountDataAccessProvider::class.java

    override fun getDeviceDataAccessProvider() = ${pluginName}DeviceDataAccessProvider::class.java

    override fun getBucketDataAccessProvider() = ${pluginName}BucketDataAccessProvider::class.java

    override fun getDynamicallyRegisteredClientDataAccessProvider() = ${pluginName}DynamicallyRegisteredClientDataAccessProvider::class.java
}
