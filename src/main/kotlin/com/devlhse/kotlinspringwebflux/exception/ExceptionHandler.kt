package com.devlhse.kotlinspringwebflux.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import reactor.core.publisher.Mono

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NameAlreadyExistsException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleNotFoundException(ex: NameAlreadyExistsException): Mono<String> {
        return Mono.just(ex.message)
    }

    @ExceptionHandler(EmailAlreadyExistsException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleNotFoundException(ex: EmailAlreadyExistsException): Mono<String> {
        return Mono.just(ex.message)
    }
}