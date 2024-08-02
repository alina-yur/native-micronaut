# Micronaut 🤝 GraalVM 🤝 H2

Run on the JVM:

```shell
mvn mn:run
```
Test:

```shell
curl "http://localhost:8080/translate?english=Hello"
```

Build a native image:

```shell
mvn package -Dpackaging=native-image
```
