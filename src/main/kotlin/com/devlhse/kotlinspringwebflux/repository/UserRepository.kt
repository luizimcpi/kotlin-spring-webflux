package com.devlhse.kotlinspringwebflux.repository

import com.devlhse.kotlinspringwebflux.model.UserDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface UserRepository : ReactiveMongoRepository<UserDocument, String> {
    fun findByEmail(email: String): Mono<UserDocument>
    fun findByName(name: String): Mono<UserDocument>
}