package org.example

import kotlinx.coroutines.runBlocking
import org.example.client.WeatherClient
import org.example.models.request.AirPollutionRequest
import org.example.models.request.CurrentWeatherRequest
import org.example.models.request.ResponseUnits
import org.example.models.request.WeatherForecastRequest

fun main() {

    runBlocking {

        println(
            WeatherClient.getCurrentWeather(
                CurrentWeatherRequest(
                    latitude = 44.34,
                    longitude = 10.99,
                    units = ResponseUnits.IMPERIAL,
                    language = "pl"
                )
            )
        )

        println(
            WeatherClient.getWeatherForecast(
                WeatherForecastRequest(
                    latitude = 44.34,
                    longitude = 10.99,
                    units = ResponseUnits.IMPERIAL,
                    language = "pl"
                )
            )
        )

        println(
            WeatherClient.getAirPollution(
                AirPollutionRequest(
                    latitude = 50.0,
                    longitude = 50.0
                )
            )
        )
    }
}