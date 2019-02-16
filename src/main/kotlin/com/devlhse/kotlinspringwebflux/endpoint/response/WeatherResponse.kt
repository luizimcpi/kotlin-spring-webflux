package com.devlhse.kotlinspringwebflux.endpoint.response

data class WeatherResponse(
    val coord: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Integer,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Integer,
    val sys: Sys,
    val id: Integer,
    val name: String,
    val cod: Integer
)

data class Coord(
    val lon: Double,
    val lat: Double
)

data class Weather(
    val id: Integer,
    val main: String,
    val description: String,
    val icon: String
)

data class Main(
    val temp: Double,
    val pressure: Integer,
    val humidity: Integer,
    val tempMin: Double,
    val tempMax: Double
)

data class Wind(
    val speed: Double,
    val deg: Integer
)

data class Clouds(
    val all: Integer
)

data class Sys(
    val type: Integer,
    val id: Integer,
    val message: Double,
    val country: String,
    val sunrise: Integer,
    val sunset: Integer
)