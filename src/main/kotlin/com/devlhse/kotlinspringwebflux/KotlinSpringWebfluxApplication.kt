package com.devlhse.kotlinspringwebflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class KotlinSpringWebfluxApplication

fun main(args: Array<String>) { runApplication<KotlinSpringWebfluxApplication>(*args) }