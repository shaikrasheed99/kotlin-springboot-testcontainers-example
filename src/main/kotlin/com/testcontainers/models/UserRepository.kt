package com.testcontainers.models

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String>