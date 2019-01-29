package com.devlhse.kotlinspringwebflux.endpoint.response

import java.time.LocalDateTime

data class UserResponse(
    val id: String,
    val name: String,
    val email: String,
    val created_at: LocalDateTime,
    val updated_at: LocalDateTime
)