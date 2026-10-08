# Curity Maven Archetypes

Maven archetypes that generate skeleton plugin projects for the Curity Identity Server. Each plugin type has a Java
archetype (`<type>-archetype`) and a Kotlin one (`kotlin-<type>-archetype`). The plugin API lives in the Curity SDK
(`se.curity.identityserver:identityserver.sdk`), JavaDocs: https://curity.io/docs/idsvr-java-plugin-sdk/latest/

## How a Maven archetype works (the parts this repo uses)

- A module with `<packaging>maven-archetype</packaging>` (enabled by the `archetype-packaging` extension in the root
  `pom.xml`) is packaged as an archetype jar.
- `src/main/resources/archetype-resources/` is the template of the generated project.
- `src/main/resources/META-INF/maven/archetype-metadata.xml` declares the `requiredProperties` the user supplies and the
  `fileSets` copied from the template:
  - `filtered="true"`: file contents are processed by Velocity, so `${groupId}`, `${pluginName}`,
    `${pluginName.toLowerCase()}` etc. are substituted. Any literal `${...}` that is not a known property (e.g. Maven's
    `${project.curityVersion}`) is left untouched.
  - `packaged="true"`: files are moved under the package directory (`${package}`, defaults to `groupId`).
  - `__pluginName__` in a file or directory name is replaced with the `pluginName` property value.
- `src/test/resources/projects/basic/` is the archetype integration test, run by `mvn install`. It generates a project
  from `archetype.properties` and runs the goal in `goal.txt` (`package`) on it, i.e. it compiles the generated code
  against the real SDK. Output lands in `<module>/target/test-classes/projects/basic/project/`.

## Structure of every archetype (example for a plugin type `Foo`)

```
foo-archetype/
  pom.xml                                   # parent io.curity:identityserver.plugins.archetypes, artifactId identityserver.plugins.archetypes.foo
  src/main/resources/META-INF/maven/archetype-metadata.xml
  src/main/resources/archetype-resources/
    .gitignore
    pom.xml                                 # generated plugin POM, SDK dependency in `provided` scope
    README.rst                              # build / install / configure instructions of the generated plugin
    src/main/java/__pluginName__/__pluginName__Foo.java            # (src/main/kotlin and .kt for Kotlin)
    src/main/java/__pluginName__/__pluginName__FooConfig.java
    src/main/java/__pluginName__/__pluginName__FooDescriptor.java
    src/main/resources/META-INF/services/se.curity.identityserver.sdk.plugin.descriptor.FooPluginDescriptor
  src/test/resources/projects/basic/archetype.properties
  src/test/resources/projects/basic/goal.txt  # contains `package`, no trailing newline
```

Some archetypes have extra classes (request models, handlers, templates, messages), e.g. authenticators and
`token-procedure-archetype`.

## Conventions

- Generated Java package is `${package}.${pluginName}` (yes, a mixed-case package segment, this is intentional).
- `Config` is an interface extending `se.curity.identityserver.sdk.config.Configuration` with one demo parameter:
  `@Description("A parameter used for demo purposes") Integer getDemoParameter();`
- `Descriptor` implements the SDK's `<Type>PluginDescriptor<Config>`; `getPluginImplementationType()` returns
  `"${pluginName.toLowerCase()}"`.
- The plugin class takes the config in its constructor and stores it in `_configuration`. Unimplemented methods
  `throw new UnsupportedOperationException();` with `// TODO:` comments that explain the contract and link to examples
  (`https://github.com/search?q=topic%3A<type>+org%3Acurityio`) or JavaDocs.
- Java style: Allman braces (opening brace on its own line), `final` classes, 4-space indentation.
- Generated POM: Java 21 (`maven-compiler-plugin` 3.14.0, `<source>/<target>` 21). Kotlin: `kotlin-maven-plugin`
  with `kotlin.version` 2.2.0, `<jvmTarget>21</jvmTarget>`, `kotlin-stdlib` in `provided` scope.
- `curitySdkVersion` default is 10.4.2 in all archetypes, **unless the plugin type requires a newer SDK** (e.g.
  `password-transformer-archetype` uses 11.5.0 because `PasswordTransformerPluginDescriptor` is `@since 11.5.0`). Always
  check the `Since:` of the descriptor in the JavaDocs and keep `archetype-metadata.xml` and `archetype.properties` in
  sync.
- Always implement against the newest available version of the Curity SDK.
- In the archetype's template README never add information about the minimum Curity SDK version.
- All modules share one version, set in the root `pom.xml` and in each module's `<parent>`. Bumping it means updating
  every module POM and the `-DarchetypeVersion` in `README.md`.
- Ensure that the archetype's pom.xml has a short, appropriate description.

## Adding a new archetype (checklist)

1. Copy the closest existing archetype (the SAML attribute provider is the smallest, cleanest template).
2. Rename module dir, `artifactId` (`identityserver.plugins.archetypes.<type>`, `kotlin-<type>` for Kotlin) and `<name>`
   in the module `pom.xml`.
3. In `archetype-metadata.xml` set `<archetype-descriptor name="<type>-archetype">` (some existing ones wrongly say
   `claims-provider-archetype` - don't copy that) and the `curitySdkVersion` default.
4. Write the Java/Kotlin classes against the exact SDK signatures. Verify them against the real jar, e.g.
   `javap -cp ~/.m2/repository/se/curity/identityserver/identityserver.sdk/<ver>/identityserver.sdk-<ver>.jar <class>`.
5. Rename the `META-INF/services/` file to the fully qualified descriptor interface name; its content is
   `${package}.${pluginName}.${pluginName}<Type>Descriptor`.
6. Update the generated `README.rst` and `pom.xml` `<name>`.
7. Update `src/test/resources/projects/basic/archetype.properties` (artifactId, pluginName, curitySdkVersion).
8. Register the module in the root `pom.xml` `<modules>` (Java ones first, then Kotlin ones, alphabetical) and add the
   plugin type to the list in `README.md`.
9. Do both the Java and the Kotlin variant.
10. Verify: `mvn install -pl <module>` must end with `BUILD SUCCESS` for both the archetype and the generated project.
    Inspect the generated project in `target/test-classes/projects/basic/project/` for unresolved placeholders.

## Building and gotchas

- `mvn install` builds all archetypes and runs every integration test; `mvn install -pl <module>` builds one.
- The first build needs network access (`-o` fails until the archetype plugin's dependencies are cached).
- `.gitignore` files in `archetype-resources` are currently NOT packaged into the archetype jars (dropped by the
  resources plugin's default excludes), so generated projects don't get one.
- Integration test plugin names include the type (e.g. `HelloWorldSamlAttributeProvider`), so the generated classes get a
  doubled suffix (`HelloWorldSamlAttributeProviderSamlAttributeProvider`). That's expected.
- Releases are published to Maven Central with `-P release` (GPG signing + `central-publishing-maven-plugin`).
