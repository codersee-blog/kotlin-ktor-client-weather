package org.example.models.response

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class WeatherForecast(
    @SerialName("cod") val code: String,
    @SerialName("message") val message: Int,
    @SerialName("cnt") val count: Int,
    @SerialName("list") val forecasts: List<Forecast>,
    @SerialName("city") val city: City
) {
    @Serializable
    data class Forecast(
        @SerialName("dt") val dateTime: Long,
        @SerialName("main") val main: Main,
        @SerialName("weather") val weather: List<Weather>,
        @SerialName("clouds") val clouds: Clouds,
        @SerialName("wind") val wind: Wind,
        @SerialName("visibility") val visibility: Int,
        @SerialName("pop") val probabilityOfPrecipitation: Double,
        @SerialName("rain")
        @EncodeDefault
        val rain: Rain? = null,
        @SerialName("snow")
        @EncodeDefault
        val snow: Snow? = null,
        @SerialName("sys") val system: System,
        @SerialName("dt_txt") val dateTimeText: String
    )

    @Serializable
    data class Main(
        @SerialName("temp") val temperature: Double,
        @SerialName("feels_like") val feelsLike: Double,
        @SerialName("temp_min") val tempMin: Double,
        @SerialName("temp_max") val tempMax: Double,
        @SerialName("pressure") val pressure: Int,
        @SerialName("sea_level") val seaLevel: Int,
        @SerialName("grnd_level") val groundLevel: Int,
        @SerialName("humidity") val humidity: Int,
        @SerialName("temp_kf") val tempKf: Double
    )

    @Serializable
    data class Weather(
        @SerialName("id") val id: Int,
        @SerialName("main") val main: String,
        @SerialName("description") val description: String,
        @SerialName("icon") val icon: String
    )

    @Serializable
    data class Clouds(
        @SerialName("all") val all: Int
    )

    @Serializable
    data class Wind(
        @SerialName("speed") val speed: Double,
        @SerialName("deg") val degree: Int,
        @SerialName("gust") val gust: Double
    )

    @Serializable
    data class Rain(
        @SerialName("3h")
        @EncodeDefault
        val volumeLastThreeHours: Double? = null
    )

    @Serializable
    data class Snow(
        @SerialName("3h")
        @EncodeDefault
        val volumeLastThreeHours: Double? = null
    )

    @Serializable
    data class System(
        @SerialName("pod") val partOfDay: String
    )

    @Serializable
    data class City(
        @SerialName("id") val id: Int,
        @SerialName("name") val name: String,
        @SerialName("coord") val coordinates: Coordinates,
        @SerialName("country") val country: String,
        @SerialName("population") val population: Int,
        @SerialName("timezone") val timezone: Int,
        @SerialName("sunrise") val sunrise: Long,
        @SerialName("sunset") val sunset: Long
    )

    @Serializable
    data class Coordinates(
        @SerialName("lat") val latitude: Double,
        @SerialName("lon") val longitude: Double
    )
}