package org.example.models.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AirPollution(
    @SerialName("coord") val coordinates: Coordinates,
    @SerialName("list") val weatherDataList: List<WeatherData>
) {

    @Serializable
    data class Coordinates(
        @SerialName("lon") val longitude: Double,
        @SerialName("lat") val latitude: Double
    )


    @Serializable
    data class WeatherData(
        @SerialName("dt") val dateTime: Long,
        @SerialName("main") val main: Main,
        @SerialName("components") val components: Components
    )

    @Serializable
    data class Main(
        @SerialName("aqi") val airQualityIndex: Int
    )

    @Serializable
    data class Components(
        @SerialName("co") val carbonMonoxide: Double,
        @SerialName("no") val nitrogenMonoxide: Double,
        @SerialName("no2") val nitrogenDioxide: Double,
        @SerialName("o3") val ozone: Double,
        @SerialName("so2") val sulphurDioxide: Double,
        @SerialName("pm2_5") val fineParticlesMatter: Double,
        @SerialName("pm10") val coarseParticulateMatter: Double,
        @SerialName("nh3") val ammonia: Double
    )
}


