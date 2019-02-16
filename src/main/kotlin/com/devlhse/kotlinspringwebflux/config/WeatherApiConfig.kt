package com.devlhse.kotlinspringwebflux.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class WeatherApiConfig {

    @Value("\${api.weather.url}")
    val weatherApiUrl: String? = null

    @Value("\${api.weather.key}")
    val weatherApiKey: String? = null
}