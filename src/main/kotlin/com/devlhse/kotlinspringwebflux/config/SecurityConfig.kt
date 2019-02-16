package com.devlhse.kotlinspringwebflux.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    fun securitygWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
                .csrf().disable()
                .formLogin().disable()
                .authorizeExchange()
                .pathMatchers("/actuator/**", "/users/**", "/weather/**").permitAll()
                .anyExchange().authenticated()
                .and().build()
    }
}