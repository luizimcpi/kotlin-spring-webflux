package com.devlhse.kotlinspringwebflux.service

import com.devlhse.kotlinspringwebflux.model.User
import reactor.core.publisher.Mono

interface UserService {

    fun create(user: User): Mono<User>
}