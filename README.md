# GraalVM & Micronaut 🤝

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

Now let's design our application. It will be a home library application, containing books and exposing several endpoints to retrieve them.
