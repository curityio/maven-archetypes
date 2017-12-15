/*
 *  Copyright 2017 Curity AB
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package ${groupId}.config;

import se.curity.identityserver.sdk.config.Configuration;
import se.curity.identityserver.sdk.config.annotation.DefaultString;
import se.curity.identityserver.sdk.config.annotation.DefaultURI;
import se.curity.identityserver.sdk.config.annotation.Description;
import se.curity.identityserver.sdk.service.SessionManager;

import java.net.URI;

@SuppressWarnings("InterfaceNeverImplemented")
public interface AuthenticatorPluginConfig extends Configuration {
    @Description("Client id")
    String getClientId();

    @Description("Secret key")
    String getClientSecret();

    @Description("URL to the Custom authorization endpoint")
    @DefaultURI("https://account.custom.com/api/oauth2/authorize")
    URI getAuthorizationEndpoint();

    @Description("URL to the Custom token endpoint")
    @DefaultURI("https://api.custom.com/oauth2/token")
    URI getTokenEndpoint();

    @Description("URL to Custom user info endpoint")
    @DefaultURI("https://api.custom.com/2.0/users/me")
    URI getUserInfoEndpoint();

    @Description("A space-separated list of scopes to request from Custom")
    @DefaultString("")
    String getScope();

    SessionManager getSessionManager();

}
