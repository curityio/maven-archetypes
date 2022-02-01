package ${package}.config


import se.curity.identityserver.sdk.config.Configuration
import se.curity.identityserver.sdk.config.annotation.Description
import se.curity.identityserver.sdk.service.ExceptionFactory
import se.curity.identityserver.sdk.service.HttpClient
import se.curity.identityserver.sdk.service.Json
import se.curity.identityserver.sdk.service.SessionManager
import se.curity.identityserver.sdk.service.WebServiceClientFactory
import se.curity.identityserver.sdk.service.authentication.AuthenticatorInformationProvider

import java.util.Optional

interface ${pluginName}AuthenticatorPluginConfig: Configuration
{
    @Description("Client id")
    fun getClientId(): String

    @Description("Secret key")
    fun getClientSecret(): String

    @Description("The HTTP client with any proxy and TLS settings that will be used to connect to the provider")
    fun getHttpClient(): Optional<HttpClient>

    fun getSessionManager(): SessionManager

    fun getExceptionFactory(): ExceptionFactory

    fun getAuthenticatorInformationProvider(): AuthenticatorInformationProvider

    fun getWebServiceClientFactory(): WebServiceClientFactory

    fun getJson(): Json
}
