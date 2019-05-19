# ReformCloud Examples

These are the official ReformCloud examples, which are explaining some general code snippets for developers.

You can find our documentation directly over [here](https://docs.reformcloud.systems).

You can access the apis always over our repo:
```xml
    <repositories>
        <!-- ReformCloud official repository -->
        <repository>
            <id>ReformCloud</id>
            <name>reformcloud-official</name>
            <url>https://repo.reformcloud.systems</url>
        </repository>
    </repositories>
```

The apis are now accessible over the dependency like:
```xml
        <dependency>
            <groupId>systems.reformcloud</groupId>
            <artifactId>reformcloud-controller</artifactId>
            <version>LATEST</version>
            <scope>provided</scope>
        </dependency>
```

You have to replace `LATEST` with the current cloud version.

You can also access the library for private projects using
```xml
        <dependency>
            <groupId>systems.reformcloud</groupId>
            <artifactId>reformcloud-library</artifactId>
            <version>LATEST</version>
            <scope>compile</scope>
        </dependency>
```

But here the scope has to be `compile`.

In general, the examples are split in five parts:

- The first part will explain the addons by giving some examples from addon methods to dynamic addon dependency loading.
- The second part is about the event api, by giving a listener and event example.
- The third part is about the player api, showing you how to get a player and how to make several actions through the network
- The fourth part is about the cloud service, how to use it and which methods there are.
- The last part is about server starting by giving some examples for a server startup code.

But the main thing with development is one: `Learning by doing`. If you don't try the api yourself, you will never get all providing methods.

But if there are any questions left you can contact us on [Discord](https://discord.gg/uskXdVZ)