# Curity Maven Archetypes

These project provides Maven archetypes to help you quickly create a skeleton of a plug-in that can be used with the Curity Identity Server. Currently, the following archtetypes are available:

* Vanilla authenticator
* A Kotlin-based authenticator
* OAuth- or OpenID-Connect-based authenticator

The latter is a good one to use when creating an authenticator that communicates with an upstream OAuth or OpenID Connect provider. It includes a callback to obtain an authorization code from that provider and handles the uses the token from it to create the required `AuthenticaitonResult`. The first is a good starting point for any other kind of authenticator. The Kotlin one is a good one to use if you'd like to prorgram in that language.

## Install the Archetypes Locally

To install these archetypes, just issue the command `mvn install`.

## Generate a new Plug-in Project

To create a simple authenticator that *does not* use OAuth or OpenID Connect, run the following command (after installing the archetypes):

```bash
$ mvn -B archetype:generate \
      -DarchetypeArtifactId=curity.plugin.authenticator-archetype \
      -DarchetypeGroupId=io.curity \
      -DarchetypeVersion=1.0.1  \
      -DartifactId=hello-world \
      -DgroupId=com.example.curity \
      -DpluginName=HelloWorld \
      -Dversion=1.0.0-SNAPSHOT
```

(Substitute `groupId`, `artifactId` and `version` values accordingly.)

Similarly, to create a skeleton project that uses OAuth or OpenID Connect to authenticate to an upstream provider, run this command:

```bash
$ mvn -B archetype:generate \
      -DarchetypeArtifactId=curity.plugin.oauth-authenticator-archetype \
      -DarchetypeGroupId=io.curity \
      -DarchetypeVersion=1.0.1  \
      -DartifactId=hello-world \
      -DgroupId=com.example.curity \
      -DpluginName=HelloWorld \
      -Dversion=1.0.0-SNAPSHOT
```

The only difference in these two is the `archetypeArtificateId`. Similiar to these, change the `archetypeArtificatId` to `curity.plugin.kotlin-authenticator-archetype` to generate an authenticator that uses Kotlin.

## License

These archetypes are licensed under the [Apache v. 2 license](LICENSE).

## Questions

For questions, contact Curity AB:

> info@curity.io
>
> https://curity.io

Copyright (C) 2017 Curity AB.