package com.testcontainers.models

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User, String> {
    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    fun findByEmail(email: String): List<User>
}