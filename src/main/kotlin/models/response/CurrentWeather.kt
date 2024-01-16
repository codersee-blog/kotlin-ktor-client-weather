package org.example.models.response

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class CurrentWeather(
    @SerialName("coord") val coordinates: Coordinates,
    @SerialName("weather") val weather: List<Weather>,
    @SerialName("base") val base: String,
    @SerialName("main") val main: Main,
    @SerialName("visibility") val visibility: Int,
    @SerialName("wind") val wind: Wind,
    @SerialName("rain")
    @EncodeDefault
    val rain: Rain? = null,
    @SerialName("snow")
    @EncodeDefault
    val snow: Snow? = null,
    @SerialName("clouds") val clouds: Clouds,
    @SerialName("dt") val dateTime: Long,
    @SerialName("sys") val systemData: SystemData,
    @SerialName("timezone") val timezone: Int,
    @SerialName("id") val cityId: Int,
    @SerialName("name") val cityName: String,
    @SerialName("cod") val code: Int
) {

    @Serializable
    data class Coordinates(
        @SerialName("lon") val longitude: Double,
        @SerialName("lat") val latitude: Double
    )

    @Serializable
    data class Weather(
        @SerialName("id") val id: Int,
        @SerialName("main") val main: String,
        @SerialName("description") val description: String,
        @SerialName("icon") val icon: String
    )

    @Serializable
    data class Main(
        @SerialName("temp") val temperature: Double,
        @SerialName("feels_like") val feelsLike: Double,
        @SerialName("temp_min") val tempMin: Double,
        @SerialName("temp_max") val tempMax: Double,
        @SerialName("pressure") val pressure: Int,
        @SerialName("humidity") val humidity: Int,
        @SerialName("sea_level") val seaLevel: Int,
        @SerialName("grnd_level") val groundLevel: Int
    )

    @Serializable
    data class Wind(
        @SerialName("speed") val speed: Double,
        @SerialName("deg") val direction: Int,
        @SerialName("gust") val gust: Double
    )

    @Serializable
    data class Rain(
        @SerialName("1h")
        @EncodeDefault
        val oneHour: Double? = null,
        @SerialName("3h")
        @EncodeDefault
        val threeHours: Double? = null
    )

    @Serializable
    data class Snow(
        @SerialName("1h")
        @EncodeDefault
        val oneHour: Double? = null,
        @SerialName("3h")
        @EncodeDefault
        val threeHours: Double? = null
    )

    @Serializable
    data class Clouds(
        @SerialName("all") val all: Int
    )

    @Serializable
    data class SystemData(
        @SerialName("type") val type: Int,
        @SerialName("id") val id: Int,
        @SerialName("country") val country: String,
        @SerialName("sunrise") val sunrise: Long,
        @SerialName("sunset") val sunset: Long
    )
}

