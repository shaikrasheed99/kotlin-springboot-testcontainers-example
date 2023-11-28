# Testcontainers with Spring Boot in Kotlin

In this example, I have created a simple Spring Boot project integrated with JPA to interact with a PostgreSQL database.

This project includes two sets of tests:

* **Unit Tests:**
    * Uses a local machine's postgres database for testing.

* **Integration Tests with Testcontainers:**
    * Uses Testcontainers to run tests with a real PostgreSQL container.

## Testcontainers

[Testcontainers](https://testcontainers.com/), a powerful Java library that simplifies and enhances the testing of your applications by providing
disposable containers for databases, web browsers, and more.

Testcontainers allows you to write more realistic and reliable tests by running your dependencies, such as databases, in
isolated containers.

* **Easily Manage Dependencies:**
    * Run databases, queues, and other services as Docker containers for testing purposes.

* **Realistic Testing:**
    * Testcontainers allows you to test against real instances of your dependencies, ensuring a more accurate
      representation of your production environment.

* **Disposable Containers:**
    * Containers are started before tests and stopped afterward, ensuring a clean and isolated environment for each
      test.

## Getting Started

1. Clone the Repository:

```bash
git clone https://github.com/shaikrasheed99/kotlin-springboot-testcontainers-example
```

2. Move to the project directory:

```bash
cd kotlin-springboot-testcontainers-example
```

3. Build the Project:

```bash
./gradlew clean build
```

4. Run the Application:

```bash
./gradlew bootRun
```

The application will start, and you can access it at `http://localhost:8080`.