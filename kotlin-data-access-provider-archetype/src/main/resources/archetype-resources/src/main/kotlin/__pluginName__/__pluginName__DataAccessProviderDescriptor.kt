package ${package}.${pluginName}

import se.curity.identityserver.sdk.datasource.BucketDataAccessProvider
import se.curity.identityserver.sdk.datasource.CredentialDataAccessProvider
import se.curity.identityserver.sdk.datasource.DeviceDataAccessProvider
import se.curity.identityserver.sdk.datasource.DynamicallyRegisteredClientDataAccessProvider
import se.curity.identityserver.sdk.datasource.UserAccountDataAccessProvider
import se.curity.identityserver.sdk.plugin.descriptor.DataAccessProviderPluginDescriptor

class ${pluginName}DataAccessProviderDescriptor: DataAccessProviderPluginDescriptor<${pluginName}DataAccessProviderConfig>
{
    override fun getPluginImplementationType(): String = "${pluginName.toLowerCase()}"

    override fun getConfigurationType(): Class<out ${pluginName}DataAccessProviderConfig> = ${pluginName}DataAccessProviderConfig::class.java

    override fun getCredentialDataAccessProvider(): Class<out CredentialDataAccessProvider>? = ${pluginName}CredentialDataAccessProvider::class.java

    override fun getUserAccountDataAccessProvider(): Class<out UserAccountDataAccessProvider>? = ${pluginName}UserAccountDataAccessProvider::class.java

    override fun getDeviceDataAccessProvider(): Class<out DeviceDataAccessProvider>? = ${pluginName}DeviceDataAccessProvider::class.java

    override fun getBucketDataAccessProvider(): Class<out BucketDataAccessProvider>? = ${pluginName}BucketDataAccessProvider::class.java

    override fun getDynamicallyRegisteredClientDataAccessProvider(): Class<out DynamicallyRegisteredClientDataAccessProvider>?
            = ${pluginName}DynamicallyRegisteredClientDataAccessProvider::class.java
}
