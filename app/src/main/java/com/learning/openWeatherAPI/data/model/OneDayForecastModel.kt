package com.learning.openWeatherAPI.data.model

import com.google.gson.annotations.SerializedName

// TODO: take into account data params from the API

data class OneDayForecastModel(
    @SerializedName("dt") val time: String = "",
    val main: DayTempAndHumidity = DayTempAndHumidity(),
    val wind: DayWind = DayWind(),
    val weather: List<WeatherDesc> = emptyList()
)

data class DayTempAndHumidity(
    val temp: Double = 999.99,
    val humidity: Int = -1
)

data class DayWind(
    @SerializedName("speed") val windSpeed: Double = -1.0
)

data class WeatherDesc(
    @SerializedName("description") val weatherDesc:String = ""
)
