package com.devlhse.kotlinspringwebflux.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.UUID

data class User(val id: String = UUID.randomUUID().toString(), val name: String, val email: String, val password: String, val salt: String, val created_at: LocalDateTime = LocalDateTime.now(), val updated_at: LocalDateTime?)

@Document("user")
data class UserDocument(val id: String = UUID.randomUUID().toString(), val name: String, val email: String, val password: String, val salt: String, val created_at: LocalDateTime = LocalDateTime.now(), val updated_at: LocalDateTime?)