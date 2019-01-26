package com.devlhse.kotlinspringwebflux.endpoint.request

import com.devlhse.kotlinspringwebflux.model.User
import java.time.LocalDateTime
import java.util.*

data class UserRequest(val name: String, val email: String, val password: String)

fun toModel(userRequest: UserRequest): User {
    return User(UUID.randomUUID().toString(), userRequest.name, userRequest.email, userRequest.password, LocalDateTime.now(), LocalDateTime.now())
}