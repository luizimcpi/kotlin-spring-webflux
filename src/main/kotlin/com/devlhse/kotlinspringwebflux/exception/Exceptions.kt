package com.devlhse.kotlinspringwebflux.exception

class NameAlreadyExistsException(override var message: String) : Exception(message)
class EmailAlreadyExistsException(override var message: String) : Exception(message)