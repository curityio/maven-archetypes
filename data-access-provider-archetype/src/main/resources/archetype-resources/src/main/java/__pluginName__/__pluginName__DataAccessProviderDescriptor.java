package ${package}.${pluginName};

import se.curity.identityserver.sdk.Nullable;
import se.curity.identityserver.sdk.datasource.BucketDataAccessProvider;
import se.curity.identityserver.sdk.datasource.CredentialDataAccessProvider;
import se.curity.identityserver.sdk.datasource.DeviceDataAccessProvider;
import se.curity.identityserver.sdk.datasource.DynamicallyRegisteredClientDataAccessProvider;
import se.curity.identityserver.sdk.datasource.UserAccountDataAccessProvider;
import se.curity.identityserver.sdk.plugin.descriptor.DataAccessProviderPluginDescriptor;

public final class ${pluginName}DataAccessProviderDescriptor implements DataAccessProviderPluginDescriptor<${pluginName}DataAccessProviderConfig> {

    @Override
    public String getPluginImplementationType()
    {
        return "${pluginName.toLowerCase()}";
    }

    @Override
    public Class<? extends ${pluginName}DataAccessProviderConfig> getConfigurationType()
    {
        return ${pluginName}DataAccessProviderConfig.class;
    }

    @Nullable
    @Override
    public Class<? extends CredentialDataAccessProvider> getCredentialDataAccessProvider()
    {
        return ${pluginName}CredentialDataAccessProvider.class;
    }

    @Nullable
    @Override
    public Class<? extends UserAccountDataAccessProvider> getUserAccountDataAccessProvider()
    {
        return ${pluginName}UserAccountDataAccessProvider.class;
    }

    @Nullable
    @Override
    public Class<? extends DeviceDataAccessProvider> getDeviceDataAccessProvider()
    {
        return ${pluginName}DeviceDataAccessProvider.class;
    }

    @Nullable
    @Override
    public Class<? extends BucketDataAccessProvider> getBucketDataAccessProvider()
    {
        return ${pluginName}BucketDataAccessProvider.class;
    }

    @Nullable
    @Override
    public Class<? extends DynamicallyRegisteredClientDataAccessProvider> getDynamicallyRegisteredClientDataAccessProvider()
    {
        return ${pluginName}DynamicallyRegisteredClientDataAccessProvider.class;
    }
}
