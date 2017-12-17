${pluginName} Authenticator Plugin
=============================================

${pluginName} OAuth Authenticator plugin for the Curity Identity Server.

Create `Custom app`_

Create ${pluginName} Authenticator and configure the following values.

Configuration
~~~~~~~~~~~~~

+-------------------+--------------------------------------------------+-----------------------------+
| Name              | Default                                          | Description                 |
+===================+==================================================+=============================+
| ``Client ID``     |                                                  | OAuth app client id         |
|                   |                                                  |                             |
+-------------------+--------------------------------------------------+-----------------------------+
| ``Client Secret`` |                                                  | OAuth app secret key        |
|                   |                                                  |                             |
+-------------------+--------------------------------------------------+-----------------------------+
| ``Authorization`` | ``https://identity.example.com/authorize``       | URL to the OAuth            |
| ``Endpoint``      |                                                  | authorization endpoint      |
|                   |                                                  |                             |
+-------------------+--------------------------------------------------+-----------------------------+
| ``Token``         | ``https://identity.example.com/token``           | URL to the OAuth            |
| ``Endpoint``      |                                                  | token endpoint              |
+-------------------+--------------------------------------------------+-----------------------------+
| ``UserInfo``      | ``https://identity.example.com/user-info``       | URL to the OpenID Connect   |
| ``Endpoint``      |                                                  | userinfo endpoint           |
+-------------------+--------------------------------------------------+-----------------------------+
| ``Scope``         | ``""``                                           | A space-separated list of   |
|                   |                                                  | scopes to request from      |
|                   |                                                  | OAuth                       |
+-------------------+--------------------------------------------------+-----------------------------+

Build plugin
~~~~~~~~~~~~

First, collect credentials to the Curity Nexus, to be able to fetch the
SDK. Add nexus credentials in maven settings.

Then, build the plugin by: ``mvn clean package``

Install plugin
~~~~~~~~~~~~~~

| To install a plugin into the server, simply drop its jars and all of
  its required resources, including Server-Provided Dependencies, in the
  ``<plugin_group>`` directory.
| Please visit `curity.io/plugins`_ for more information about plugin
  installation.

Required dependencies/jars
""""""""""""""""""""""""""

Following jars must be in plugin group classpath.

-  `commons-codec-1.9.jar`_
-  `commons-logging-1.2.jar`_
-  `google-collections-1.0-rc2.jar`_
-  `httpclient-4.5.jar`_
-  `httpcore-4.4.1.jar`_
-  `identityserver.plugins.oauth.authenticators-utility-1.0.0.jar`_

Please visit `curity.io`_ for more information about the Curity Identity
Server.

.. _Custom app: https://app.custom.com/developers/console/newapp
.. _curity.io/plugins: https://support.curity.io/docs/latest/developer-guide/plugins/index.html#plugin-installation
.. _commons-codec-1.9.jar: http://central.maven.org/maven2/commons-codec/commons-codec/1.9/commons-codec-1.9.jar
.. _commons-logging-1.2.jar: http://central.maven.org/maven2/commons-logging/commons-logging/1.2/commons-logging-1.2.jar
.. _google-collections-1.0-rc2.jar: http://central.maven.org/maven2/com/google/collections/google-collections/1.0-rc2/google-collections-1.0-rc2.jar
.. _httpclient-4.5.jar: http://central.maven.org/maven2/org/apache/httpcomponents/httpclient/4.5/httpclient-4.5.jar
.. _httpcore-4.4.1.jar: http://central.maven.org/maven2/org/apache/httpcomponents/httpcore/4.4.1/httpcore-4.4.1.jar
.. _identityserver.plugins.oauth.authenticators-utility-1.0.0.jar: https://github.com/curityio/oauth-authenticator-utility-plugin
.. _curity.io: https://curity.io/
