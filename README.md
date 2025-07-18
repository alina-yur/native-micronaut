# Native Micronaut 👩‍🚀

## Getting Started

Go to [micronaut.io/launch](https://micronaut.io/launch/) and generate your project. You might want to pay attention to defaults — I chose latest Java, Maven, and JUnit. For the sake of this project, our demo will be called `library`.

For now we are not adding any dependencies — support for GraalVM Native Image is already implicitly included out of the box.

Build and run the app on the JVM:

```shell
mvn mn:run
```

Build and run the app as a native image:

```shell
mvn package -Dpackaging=native-image
./target/library
```

## The Application 

Now let's design our application. It will be a home library application, containing books and exposing several endpoints to retrieve them. For that, we added Library and Book classes, and a Controller, Service, and Repository to work with the data and interact with the user.

## Annotations Processors 

For Micronaut, the concept of annotation processors is very important, as Micronaut shifts most of the code discovery and generation to build time. So for example if you want to use Micronaut Serialization, you need to add the following to `annotationProcessorPaths` of `maven-compiler-plugin`:

```xml
<annotationProcessorPaths>
    <path>
        <groupId>io.micronaut.serde</groupId>
        <artifactId>micronaut-serde-processor</artifactId>
    </path>
</annotationProcessorPaths>
```



## Working with a Database 📚

The Micronaut team highly encourages using [Flyway](https://micronaut-projects.github.io/micronaut-flyway/latest/guide/) for managing database schemas. Note that flyway migrations require full control over schema management. If you manually configure `datasources.default.schema-generate`, such as set it to `CREATE_DROP`, set it to `NONE` to ensure that only Flyway manages your schema.

### MySQL 🐬

For the MySQL settings and config, go to the `mysql-experiments` branch.
https://github.com/micronaut-projects/micronaut-data


## Reflection 🪞

For cases where you have custom reflection code, and Native Image isn't able to resolve it auotmatically, the best solution is to use programmatic reflection configuration. In Micronaut, use the ` @ReflectConfig` annotation. For example:

```java
package example.micronaut;

import io.micronaut.core.annotation.ReflectionConfig;

@ReflectionConfig(
        type = StringReverser.class,
        methods = {
                @ReflectionConfig.ReflectiveMethodConfig(name = "reverse", parameterTypes = {String.class})
        }
)

public class NativeImageConfig {
}
```



## Test Resources 🧪

Micronaut Test Resources makes it easy to test applications that depend on external services like MySQL by automatically provisioning and managing those resources for you—no manual setup or container config needed. It integrates seamlessly with Testcontainers while removing the usual pain points: you don’t have to think about container lifecycles, and there’s no extra config needed, which means native image testing just works out of the box with ./gradlew nativeTest.

It also supports development mode, so you can run your app locally (or multiple related projects) and reuse the same containerized services shared across cfor example lient and server projects. This siginificantly simplifies both local development and native testing.

## Micronaut Serialization & Jackson

## Micronaut Validation & Hibernate Validator

## Micronaut & LangChain4J

```java
package example;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.micronaut.langchain4j.annotation.AiService;

@AiService
public interface TravelAgent {
    
    @SystemMessage("You are a helpful travel agent. When asked about flights, provide realistic but fictional flight information including flight numbers, airlines, departure/arrival times, and prices.")
    String findFlights(@UserMessage String request);
    
    @SystemMessage("You are a knowledgeable travel agent. When asked about hotels, provide realistic but fictional hotel information including hotel names, star ratings, and rates. Be enthusiastic and helpful.")
    String findHotels(@UserMessage String request);
    
    @SystemMessage("You are an experienced travel advisor. Provide helpful travel tips, weather information, and local recommendations. Be informative and encouraging.")
    String getTravelAdvice(@UserMessage String request);
}
```


## Micronaut Control Panel

The Micronaut Control Panel module provides a web UI that allows you to view and manage the state of your Micronaut application, typically in a development environment.

## To do

[] Add MySQL via Podman <br>
[] Add Oracle Database via Podman <br>
[] Add OCI instructions <br>
[] SBOM: Custom management endpoint <br>
