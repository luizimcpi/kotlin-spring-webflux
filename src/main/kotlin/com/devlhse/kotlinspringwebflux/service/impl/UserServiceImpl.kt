package com.devlhse.kotlinspringwebflux.service.impl

import com.devlhse.kotlinspringwebflux.exception.EmailAlreadyExistsException
import com.devlhse.kotlinspringwebflux.exception.NameAlreadyExistsException
import com.devlhse.kotlinspringwebflux.model.User
import com.devlhse.kotlinspringwebflux.model.UserDocument
import com.devlhse.kotlinspringwebflux.repository.UserRepository
import com.devlhse.kotlinspringwebflux.service.UserService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun create(user: User): Mono<User> {
        return validateUser(user)
            .flatMap { userRepository.save(toDocument(it)) }
            .map { toModel(it) }
    }

    private fun validateUser(user: User): Mono<User> {
        val emailExists = userRepository.findByEmail(user.email)
                .flatMap { Mono.error<User>(EmailAlreadyExistsException("Email já cadastrado")) }

        val nameExists = userRepository.findByName(user.name)
                .flatMap { Mono.error<User>(NameAlreadyExistsException("Nome já cadastrado")) }

        return Flux.merge(emailExists, nameExists)
                .then(Mono.just(user))
    }

    private fun toDocument(user: User): UserDocument {
        return UserDocument(user.id, user.name, user.email, user.password, user.created_at, user.updated_at)
    }

    private fun toModel(userDocument: UserDocument): User {
        return User(userDocument.id, userDocument.name, userDocument.email, userDocument.password, userDocument.created_at, userDocument.updated_at)
    }
}
