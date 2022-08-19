# Curity Maven Archetypes

[![Quality](https://img.shields.io/badge/quality-production-green)](https://curity.io/resources/code-examples/status/)
[![Availability](https://img.shields.io/badge/availability-binary-blue)](https://curity.io/resources/code-examples/status/)

This project provides Maven archetypes to help you quickly create a skeleton of a plug-in which can be used with the Curity
Identity Server. Currently, the following archetypes are available:

* Alarms Handler
* Authenticator:
    * Vanilla
    * OAuth- or OpenID-Connect-based
    * Back-channel
* Authentication Action
* Authorization Manager
* Claims Provider
* Consentor:
    * Consentor-based
    * Signing Consentor-based
* Data Access Provider
* Email Sender
* Event Listener
* SMS Sender

All the archetypes are also available in Kotlin version.

The `oauth-authenticator-archetype` is a good one to use when creating an authenticator that communicates with an upstream
OAuth or OpenID Connect provider. It includes a callback to obtain an authorization code from that provider and uses the
code to obtain a token from it to create the required `AuthenticaitonResult`. The `authentication-action-archetype` is a
good starting point for any other kind of authenticator. The Kotlin one is a good one to use if you'd like to program in
that language.

## Install the Archetypes Locally

To install these archetypes, just issue the command `mvn install`.

## Generate a new Plug-in Project

To create a simple authenticator that *does not* use OAuth or OpenID Connect, run the following command (after installing the archetypes):

```bash
$ mvn -B archetype:generate \
      -DarchetypeArtifactId=identityserver.plugins.archetypes.authenticator \
      -DarchetypeGroupId=io.curity \
      -DarchetypeVersion=3.0.0  \
      -DartifactId=hello-world \
      -DgroupId=com.example.curity \
      -DpluginName=HelloWorld \
      -Dversion=1.0.0-SNAPSHOT
```

(Substitute `groupId`, `artifactId` and `version` values accordingly.)

Similarly, to create a skeleton project that uses OAuth or OpenID Connect to authenticate to an upstream provider, run this command:

```bash
$ mvn -B archetype:generate \
      -DarchetypeArtifactId=identityserver.plugins.archetypes.oauth-authenticator \
      -DarchetypeGroupId=io.curity \
      -DarchetypeVersion=3.0.0  \
      -DartifactId=hello-world \
      -DgroupId=com.example.curity \
      -DpluginName=HelloWorld \
      -Dversion=1.0.0-SNAPSHOT
```

The only difference in these two, is the `archetypeArtifactId`. Change the `archetypeArtifactId` to any other value to
create an appropriate plugin. You can find the artifact IDs in the `pom.xml` file of each of the archetype.

E.g. to create the Event Listener plugin, use this command:

```bash
$ mvn -B archetype:generate \
      -DarchetypeArtifactId=identityserver.plugins.archetypes.event-listener \
      -DarchetypeGroupId=io.curity \
      -DarchetypeVersion=3.0.0 \
      -DartifactId=hello-world \
      -DgroupId=com.example.curity \
      -DpluginName=HelloWorld \
      -Dversion=1.0.0-SNAPSHOT

```

## License

These archetypes are licensed under the [Apache v. 2 license](LICENSE).

## Questions

For questions, contact Curity AB:

> info@curity.io
>
> https://curity.io

Copyright (C) 2022 Curity AB.
