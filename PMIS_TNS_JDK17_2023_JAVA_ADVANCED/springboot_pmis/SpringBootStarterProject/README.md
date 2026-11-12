# Spring Boot Starter Project

A beginner-friendly Maven Spring Boot project structured like the screenshot, using package `com.spring.boot`.

## Requirements
- JDK 17 or newer
- Maven 3.6+ (or open `pom.xml` in IntelliJ IDEA and let Maven import the project)

## Run in IntelliJ IDEA
1. Extract the ZIP file.
2. Open the extracted `SpringBootStarterProject` folder (the folder containing `pom.xml`).
3. Allow IntelliJ IDEA to load the Maven project and download dependencies.
4. Run `BootApplication.java`.
5. Visit `http://localhost:8080/api/hello`.

## Run from a terminal
```bash
mvn spring-boot:run
```

## Example endpoints
- `GET http://localhost:8080/api/hello` — returns a greeting.
- `GET http://localhost:8080/api/person` — returns a sample person as JSON.
- `POST http://localhost:8080/api/person` — accepts a person JSON body.

Example POST body:
```json
{
  "name": "Adarsh",
  "age": 22
}
```

## Project structure
```text
src/main/java/com/spring/boot/
├── BootApplication.java
├── BasicProgramsController.java
├── Person.java
├── printHello.java
└── coupling/
    └── CouplingExample.java
src/main/resources/application.properties
src/test/java/com/spring/boot/BootApplicationTests.java
pom.xml
```

The project uses Spring Boot 3.5.6 and Java 17. The dependencies are downloaded by Maven on first import/build.
