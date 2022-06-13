package com.learning.openWeatherAPI.data.model

class OneDayForecastProvider {
    companion object {

        // dummy forecast
        val oneDayForecast = OneDayForecastModel()

        // get forecast
        fun getForecast():OneDayForecastModel{
            return oneDayForecast
        }
    }
}