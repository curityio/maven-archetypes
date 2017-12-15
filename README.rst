Authenticator Maven Archetype
=============================

Curity OAuth Authenticator Maven Archetype


Install plugin in local maven
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Install the plugin by: ``mvn clean install``


Generate Project
~~~~~~~~~~~~~~~~

Generate project by following command.
Substitute groupId, artifactId and version values accordingly.
::

     mvn archetype:generate -DarchetypeGroupId=io.curity  -DarchetypeArtifactId=curity.authenticator
     -DarchetypeVersion=1.0.0  -DgroupId=io.curity.identityserver.plugins.authenticators
     -DartifactId=test -Dversion=1.0.0


