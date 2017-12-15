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

package ${groupId}.descriptor;

import com.google.common.collect.ImmutableMap;
import ${groupId}.authentication.CallbackRequestHandler;
import ${groupId}.authentication.CustomAuthenticatorRequestHandler;
import ${groupId}.config.AuthenticatorPluginConfig;
import se.curity.identityserver.sdk.authentication.AuthenticatorRequestHandler;
import se.curity.identityserver.sdk.plugin.descriptor.AuthenticatorPluginDescriptor;

import java.util.Map;

public final class CustomAuthenticatorPluginDescriptor
        implements AuthenticatorPluginDescriptor<AuthenticatorPluginConfig> {
    public final static String INDEX = "index";
    public final static String CALLBACK = "callback";

    @Override
    public String getPluginImplementationType() {
        return ${artifactId};
    }

    @Override
    public Class<? extends AuthenticatorPluginConfig> getConfigurationType() {
        return AuthenticatorPluginConfig.class;
    }

    @Override
    public Map<String, Class<? extends AuthenticatorRequestHandler<?>>> getAuthenticationRequestHandlerTypes() {
        return ImmutableMap.of(
                INDEX, CustomAuthenticatorRequestHandler.class,
                CALLBACK, CallbackRequestHandler.class);
    }

}
