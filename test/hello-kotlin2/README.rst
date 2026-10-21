HelloKotlin2 Token Issuance Authorizer Plugin
===============================================

A custom Token Issuance Authorizer plugin for the Curity Identity Server, to decide with custom logic which scopes can be issued in tokens.

Building the Plugin
~~~~~~~~~~~~~~~~~~~

Build the plugin by issuing the command ``mvn package``. This will produce a JAR file in the ``target`` directory, which can be installed.

Installing the Plugin
~~~~~~~~~~~~~~~~~~~~~

To install the plugin, copy the compiled JAR and JARs of the dependencies not provided by the Curity Identity Server from the ``target`` directory into the :file:`${IDSVR_HOME}/usr/share/plugins/HelloKotlin2`. `${IDSVR_HOME}` is the installation folder of the Curity Identity Server. Inside of a Docker container that uses an official image of the Curity Identity Server, the installation directory is `/opt/idsvr`. Make sure to copy the JARs on each node that run the Curity Identity Server, including the admin node. Restart the Curity Identity Server so that it can load the plugin. For more information about installing plugins, refer to the `curity.io/plugins`_.

Configuring the Plugin
~~~~~~~~~~~~~~~~~~~~~~

Create a token issuance authorizer of the plugin's type in the Token Service profile, under **Scopes and Claims** → **Token Authorization**. Then, select that authorizer for the scopes it should authorize, or use it as one of the profile's global authorizers. For more information, see the `token issuance authorizers tutorial`_.

Required Dependencies
"""""""""""""""""""""

For a list of the dependencies and their versions, run ``mvn dependency:list``. Ensure that all of these are installed in
the plugin directory, except for the JARs provided by the Curity Identity Server (you can find the provided dependencies in `the documentation`_). Otherwise, they will not be accessible to this plugin and run-time errors will result.

More Information
~~~~~~~~~~~~~~~~

Please visit `curity.io`_ for more information about the Curity Identity Server.

.. _curity.io/plugins: https://curity.io/docs/idsvr/latest/developer-guide/plugins/index.html#plugin-installation
.. _curity.io: https://curity.io/
.. _token issuance authorizers tutorial: https://curity.io/resources/learn/configure-token-issuance-authorizers/
.. _the documentation: https://curity.io/docs/idsvr/latest/developer-guide/plugins/index.html#server-provided-dependencies-1
