package com.devlhse.kotlinspringwebflux.service.impl

import com.devlhse.kotlinspringwebflux.config.WeatherApiConfig
import com.devlhse.kotlinspringwebflux.constants.ApplicationConstants.Companion.CITY_PARAMETER
import com.devlhse.kotlinspringwebflux.endpoint.response.WeatherResponse
import com.devlhse.kotlinspringwebflux.service.WeatherService
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class WeatherServiceImpl(private val weatherApiConfig: WeatherApiConfig, private val client: WebClient) : WeatherService {

    override fun getCityWeatherInfo(cityName: String): Mono<WeatherResponse> {
        val formatedUrl = weatherApiConfig.weatherApiUrl + CITY_PARAMETER + weatherApiConfig.weatherApiKey
        return client.get()
                .uri(formatedUrl, cityName)
                .retrieve()
                .bodyToMono(WeatherResponse::class.java)
    }
}
