package com.devlhse.kotlinspringwebflux.model

import com.devlhse.kotlinspringwebflux.endpoint.response.UserResponse
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

data class User(
    var id: String,
    val name: String,
    val email: String,
    val password: String,
    var created_at: LocalDateTime,
    var updated_at: LocalDateTime
)

@Document("user")
data class UserDocument(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
    val created_at: LocalDateTime,
    val updated_at: LocalDateTime
)

fun toResponse(user: User): UserResponse {
    return UserResponse(user.id, user.name, user.email, user.created_at, user.updated_at)
}