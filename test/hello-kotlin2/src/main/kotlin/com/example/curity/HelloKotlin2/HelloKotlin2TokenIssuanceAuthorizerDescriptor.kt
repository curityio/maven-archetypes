package com.example.curity.HelloKotlin2

import se.curity.identityserver.sdk.plugin.descriptor.TokenIssuanceAuthorizerPluginDescriptor

class HelloKotlin2TokenIssuanceAuthorizerDescriptor: TokenIssuanceAuthorizerPluginDescriptor<HelloKotlin2TokenIssuanceAuthorizerConfig>
{
    override fun getTokenIssuanceAuthorizer() = HelloKotlin2TokenIssuanceAuthorizer::class.java

    override fun getPluginImplementationType() = "hellokotlin2"

    override fun getConfigurationType() = HelloKotlin2TokenIssuanceAuthorizerConfig::class.java
}
