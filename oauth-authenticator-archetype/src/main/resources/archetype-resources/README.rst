${pluginName} Authenticator Plug-in
===================================

.. image:: https://travis-ci.org/curityio/${artifactId}-authenticator.svg?branch=dev
     :target: https://travis-ci.org/curityio/${artifactId}-authenticator

This project provides an opens source ${pluginName} Authenticator plug-in for the Curity Identity Server. This allows an administrator to add functionality to Curity which will then enable end users to login using their ${pluginName} credentials. The app that integrates with Curity may also be configured to receive the ${pluginName} access token and refresh token, allowing it to manage resources in ${pluginName}.

System Requirements
~~~~~~~~~~~~~~~~~~~

* Curity Identity Server 3.0.0 and `its system requirements <https://developer.curity.io/docs/latest/system-admin-guide/system-requirements.html>`_

Requirements for Building from Source
"""""""""""""""""""""""""""""""""""""

* Maven 3
* Java JDK v. 8

Compiling the Plug-in from Source
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

The source is very easy to compile. To do so from a shell, issue this command: ``mvn package``.

Installation
~~~~~~~~~~~~

To install this plug-in, either download a binary version available from the `releases section of this project's GitHub repository <https://github.com/curityio/${artifactId}-authenticator/releases>`_ or compile it from source (as described above). If you compiled the plug-in from source, the package will be placed in the ``target`` subdirectory. The resulting JAR file or the one downloaded from GitHub needs to placed in the directory ``${IDSVR_HOME}/usr/share/plugins/${artifactId}``. (The name of the last directory, ``${artifactId}``, which is the plug-in group, is arbitrary and can be anything.) After doing so, the plug-in will become available as soon as the node is restarted.

.. note::

    The JAR file needs to be deployed to each run-time node and the admin node. For simple test deployments where the admin node is a run-time node, the JAR file only needs to be copied to one location.

For a more detailed explanation of installing plug-ins, refer to the `Curity developer guide <https://developer.curity.io/docs/latest/developer-guide/plugins/index.html#plugin-installation>`_.

Creating an App in ${pluginName}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

As `described in the ${pluginName} documentation <https://developer.${artifactId}.com/docs/oauth2>`_, you can `create apps <https://www.${artifactId}.com/developer/apps>`_ that use the ${pluginName} APIs as shown in the following figure:

    .. figure:: docs/images/create-${artifactId}-app.png
        :name: doc-new-${artifactId}-app
        :align: center
        :width: 500px



    .. figure:: docs/images/create-${artifactId}-app1.png
        :name: new-${artifactId}-app
        :align: center
        :width: 500px

    Fill in all the required information as shown in above image.




When you view the app's configuration after creating it, you'll find the ``Client ID`` and ``Client Secret``. These will be needed later when configuring the plug-in in Curity.

${pluginName} will also display the ``Authorized Redirect URLs`` in the new app's configuration. One of these need to match the yet-to-be-created ${pluginName} authenticator instance in Curity. The default will not work, and, if used, will result in an error. This should be updated to some URL that follows the pattern ``$baseUrl/$authenticationEndpointPath/$${artifactId}AuthnticatorId/callback``, where each of these URI components has the following meaning:

============================== ============================================================================================
URI Component                  Meaning
------------------------------ --------------------------------------------------------------------------------------------
``baseUrl``                    The base URL of the server (defined on the ``System --> General`` page of the
                               admin GUI). If this value is not set, then the server scheme, name, and port should be
                               used (e.g., ``https://localhost:8443``).
``authenticationEndpointPath`` The path of the authentication endpoint. In the admin GUI, this is located in the
                               authentication profile's ``Endpoints`` tab for the endpoint that has the type
                               ``auth-authentication``.
``${artifactId}AuthenticatorId``    This is the name given to the ${pluginName} authenticator when defining it (e.g., ``${artifactId}1``).
============================== ============================================================================================

    .. figure:: docs/images/create-${artifactId}-app2.png
        :align: center
        :width: 500px

    It could be helpful to also enable additional scopes. Scopes are the ${pluginName}-related rights or permissions that the app is requesting. If the final application (not Curity, but the downstream app) is going to perform actions using the ${pluginName} API, additional scopes probably should be enabled. Refer to the `${pluginName} documentation on scopes <https://developer.atlassian.com/cloud/${artifactId}/${artifactId}-cloud-rest-api-scopes>`_ for an explanation of those that can be enabled and what they allow.

.. warning::

    If the app configuration in ${pluginName} does not allow a certain scope (e.g., the ``Read Email Address`` scope) but that scope is enabled in the authenticator in Curity, a server error will result. For this reason, it is important to align these two configurations or not to define any when configuring the plug-in in Curity.

Creating a ${pluginName} Authenticator in Curity
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

The easiest way to configure a new ${pluginName} authenticator is using the Curity admin UI. The configuration for this can be downloaded as XML or CLI commands later, so only the steps to do this in the GUI will be described.

1. Go to the ``Authenticators`` page of the authentication profile wherein the authenticator instance should be created.
2. Click the ``New Authenticator`` button.
3. Enter a name (e.g., ``${artifactId}1``). This name needs to match the URI component in the callback URI set in the ${pluginName} app.
4. For the type, pick the ``${pluginName}`` option:

    .. figure:: docs/images/${artifactId}-authenticator-type-in-curity.png
        :align: center
        :width: 600px

5. On the next page, you can define all of the standard authenticator configuration options like any previous authenticator that should run, the resulting ACR, transformers that should executed, etc. At the bottom of the configuration page, the ${pluginName}-specific options can be found.

        .. note::

        The ${pluginName}-specific configuration is generated dynamically based on the `configuration model defined in the Java interface <https://github.com/curityio/${artifactId}-authenticator/blob/master/src/main/java/io/curity/identityserver/plugin/${artifactId}/config/${pluginName}AuthenticatorPluginConfig.java>`_.

6. Certain required and optional configuration settings may be provided. One of these is the ``HTTP Client`` setting. This is the HTTP client that will be used to communicate with the ${pluginName} OAuth server's token and user info endpoints. To define this, do the following:

    A. click the ``Facilities`` button at the top-right of the screen.
    B. Next to ``HTTP``, click ``New``.
    C. Enter some name (e.g., ``${artifactId}Client``).

        .. figure:: docs/images/${artifactId}-http-client.png
            :align: center
            :width: 400px

7. Back in the ${pluginName} authenticator instance that you started to define, select the new HTTP client from the dropdown.

        .. figure:: docs/images/http-client.png


8. In the ``Client ID`` textfield, enter the ``Client ID`` from the ${pluginName} client app.
9. Also enter the matching ``Client Secret``.
10. If you wish to limit the scopes that Curity will request of ${pluginName}, toggle on the desired scopes (e.g., ``Read Email Address`` or ``Manage Company Page``).

Once all of these changes are made, they will be staged, but not committed (i.e., not running). To make them active, click the ``Commit`` menu option in the ``Changes`` menu. Optionally enter a comment in the ``Deploy Changes`` dialogue and click ``OK``.

Once the configuration is committed and running, the authenticator can be used like any other.

License
~~~~~~~

This plugin and its associated documentation is listed under the `Apache 2 license <LICENSE>`_.

More Information
~~~~~~~~~~~~~~~~

Please visit `curity.io <https://curity.io/>`_ for more information about the Curity Identity Server.

Copyright (C) 2017 Curity AB.
