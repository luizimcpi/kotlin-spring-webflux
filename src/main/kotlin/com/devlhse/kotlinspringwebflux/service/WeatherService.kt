package com.devlhse.kotlinspringwebflux.service

import com.devlhse.kotlinspringwebflux.endpoint.response.WeatherResponse
import reactor.core.publisher.Mono

interface WeatherService {

    fun getCityWeatherInfo(cityName: String): Mono<WeatherResponse>
}