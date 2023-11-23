package com.testcontainers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TcExampleApplication

fun main(args: Array<String>) {
	runApplication<TcExampleApplication>(*args)
}
