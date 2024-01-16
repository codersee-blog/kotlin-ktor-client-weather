package org.example.client

import com.sun.tools.javac.comp.Todo
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.example.models.request.*
import org.example.models.response.AirPollution
import org.example.models.response.CurrentWeather
import org.example.models.response.WeatherForecast
import io.ktor.client.engine.apache5.*

object WeatherClient {

    private const val APP_ID: String = "********************************" //insert your own one here

    private val client = HttpClient(Apache5) {
        install(ContentNegotiation) {
            json(Json {
                isLenient = false
            })
        }
        install(Logging)
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.openweathermap.org/data/2.5"
            }
        }
    }

    suspend fun getCurrentWeather(currentWeatherRequest: CurrentWeatherRequest): CurrentWeather? {
        return try {
            val response: HttpResponse = client
                .get("/weather") {
                    url {
                        parameters.append("lat", currentWeatherRequest.latitude.toString())
                        parameters.append("lon", currentWeatherRequest.longitude.toString())
                        parameters.append("appid", APP_ID)
                        if (currentWeatherRequest.mode != null) parameters.append(
                            "mode",
                            currentWeatherRequest.mode.name()
                        )
                        if (currentWeatherRequest.units != null) parameters.append(
                            "units",
                            currentWeatherRequest.units.name()
                        )
                        if (currentWeatherRequest.language != null) parameters.append(
                            "lang",
                            currentWeatherRequest.language
                        )
                    }
                }

            if (response.status == HttpStatusCode.OK) {
                response.body<CurrentWeather>()
            } else {
                println("Failed to retrieve current weather. Status: ${response.status}")
                null
            }
        } catch (e: Exception) {
            println("Error retrieving current weather: ${e.message}")
            null
        }
    }

    suspend fun getWeatherForecast(weatherForecastRequest: WeatherForecastRequest): WeatherForecast? {
        return try {
            val response: HttpResponse = client
                .get("/forecast") {
                    url {

                        parameters.append("lat", weatherForecastRequest.latitude.toString())
                        parameters.append("lon", weatherForecastRequest.longitude.toString())
                        parameters.append("appid", APP_ID)
                        if (weatherForecastRequest.mode != null) parameters.append(
                            "mode",
                            weatherForecastRequest.mode.name()
                        )
                        if (weatherForecastRequest.units != null) parameters.append(
                            "units",
                            weatherForecastRequest.units.name()
                        )
                        if (weatherForecastRequest.language != null) parameters.append(
                            "lang",
                            weatherForecastRequest.language
                        )
                        if (weatherForecastRequest.count != null) parameters.append(
                            "cnt",
                            weatherForecastRequest.count.toString()
                        )

                    }
                }

            if (response.status == HttpStatusCode.OK) {
                response.body<WeatherForecast>()
            } else {
                println("Failed to retrieve weather forecast. Status: ${response.status}")
                null
            }
        } catch (e: Exception) {
            println("Error retrieving weather forecast: ${e.message}")
            null
        }
    }

    suspend fun getAirPollution(airPollutionRequest: AirPollutionRequest): AirPollution? {
        return try {
            val response: HttpResponse = client
                .get("/air_pollution") {
                    url {
                        parameters.append("lat", airPollutionRequest.latitude.toString())
                        parameters.append("lon", airPollutionRequest.longitude.toString())
                        parameters.append("appid", APP_ID)
                    }
                }

            if (response.status == HttpStatusCode.OK) {
                response.body<AirPollution>()
            } else {
                println("Failed to retrieve air pollution. Status: ${response.status}")
                null
            }
        } catch (e: Exception) {
            println("Error retrieving air pollution: ${e.message}")
            null
        }
    }

    fun ResponseUnits.name(): String {
        return when (this) {
            ResponseUnits.STANDARD -> "standard"
            ResponseUnits.METRIC -> "metric"
            ResponseUnits.IMPERIAL -> "imperial"
        }
    }

    fun ResponseMode.name(): String {
        return when (this) {
            ResponseMode.XML -> "xml"
        }
    }
}