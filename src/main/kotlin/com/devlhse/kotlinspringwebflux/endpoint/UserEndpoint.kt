package com.devlhse.kotlinspringwebflux.endpoint

import com.devlhse.kotlinspringwebflux.constants.ApplicationConstants.Companion.USERS_V1_CONTEXT_PATH
import com.devlhse.kotlinspringwebflux.endpoint.request.UserRequest
import com.devlhse.kotlinspringwebflux.endpoint.request.toModel
import com.devlhse.kotlinspringwebflux.endpoint.response.UserResponse
import com.devlhse.kotlinspringwebflux.model.toResponse
import com.devlhse.kotlinspringwebflux.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.logging.Logger

@RestController
class UserEndpoint (private val userService: UserService) {

    private val LOG = Logger.getLogger(UserEndpoint::class.java.getName())

    @PostMapping(USERS_V1_CONTEXT_PATH)
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody userRequest: UserRequest): Mono<UserResponse> {
        LOG.info("POST -> UserRequest has been received with values: " + userRequest.toString())

        return userService.create(toModel(userRequest))
                .map { toResponse(it) }
    }
}

