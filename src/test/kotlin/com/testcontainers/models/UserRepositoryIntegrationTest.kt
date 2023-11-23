package com.testcontainers.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryIntegrationTest {
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

        assertEquals(users.size, 1)
    }

    @Test
    internal fun shouldBeAbleToReturnEmptyListOfUsersWhenEmailIsNotFound() {
        val users = userRepository.findByEmail("emailnotfound@gmail.com")

        assertEquals(users.size, 0)
    }
}