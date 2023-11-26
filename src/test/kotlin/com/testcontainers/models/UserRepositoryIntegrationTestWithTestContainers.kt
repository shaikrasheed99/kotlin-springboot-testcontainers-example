package com.testcontainers.models

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class UserRepositoryIntegrationTestWithTestContainers {
    companion object {
        @Container
        @ServiceConnection
        private val postgreSQLContainer = PostgreSQLContainer("postgres:latest")
            .withDatabaseName("users")
            .withInitScript("users-table-db-init.sql");
    }

    @Autowired
    private lateinit var userRepository: UserRepository;

    @BeforeEach
    internal fun setUp() {
        val users = listOf<User>(
            User(
                username = "test_username_1",
                password = "test_password",
                email = "test1@gmail.com",
                role = "user"
            ),
            User(
                username = "test_username_2",
                password = "test_password",
                email = "test2@gmail.com",
                role = "admin"
            ),
        )

        userRepository.saveAll(users)
    }

    @Test
    internal fun shouldBeAbleToReturnUsersByEmail() {
        val users = userRepository.findByEmail("test1@gmail.com")

        Assertions.assertEquals(users.size, 1)
    }

    @Test
    internal fun shouldBeAbleToReturnEmptyListOfUsersWhenEmailIsNotFound() {
        val users = userRepository.findByEmail("emailnotfound@gmail.com")

        Assertions.assertEquals(users.size, 0)
    }
}