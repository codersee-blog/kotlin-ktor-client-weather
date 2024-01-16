package org.example.models.request

data class CurrentWeatherRequest(
    val latitude: Double,
    val longitude: Double,
    val mode: ResponseMode? = null,
    val units: ResponseUnits? = null,
    val language: String? = null
)