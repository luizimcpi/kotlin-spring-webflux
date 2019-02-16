package com.devlhse.kotlinspringwebflux.endpoint

import com.devlhse.kotlinspringwebflux.constants.ApplicationConstants.Companion.WHEATER_V1_CONTEXT_PATH
import com.devlhse.kotlinspringwebflux.endpoint.response.WeatherResponse
import com.devlhse.kotlinspringwebflux.service.WeatherService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.logging.Logger

@RestController
class CityWeatherEndpoint(private val weatherService: WeatherService) {

    private val LOG = Logger.getLogger(CityWeatherEndpoint::class.java.name)

    @GetMapping(WHEATER_V1_CONTEXT_PATH + "/{cityName}")
    @ResponseStatus(HttpStatus.OK)
    fun getCityWeather(@PathVariable("cityName") cityName: String): Mono<WeatherResponse> {
        LOG.info("GET -> Start find weather for city: $cityName")

        return weatherService.getCityWeatherInfo(cityName)
    }
}