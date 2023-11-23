package com.testcontainers.models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
    private val username: String,
    private val password: String,
    private val email: String,
    private val role: String
)