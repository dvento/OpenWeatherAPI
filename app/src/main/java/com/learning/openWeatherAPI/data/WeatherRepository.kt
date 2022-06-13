package com.learning.openWeatherAPI.data

import com.learning.openWeatherAPI.data.model.FiveDayForecastModel
import com.learning.openWeatherAPI.data.model.OneDayForecastModel
import com.learning.openWeatherAPI.data.network.WeatherService

class WeatherRepository {

    private val weatherApi = WeatherService()

    suspend fun getOneDayForecast(): OneDayForecastModel{
        val response: OneDayForecastModel = weatherApi.getOneDayForecast()
        //OneDayForecastProvider
        return response
    }

    suspend fun getFiveDayForecast(): FiveDayForecastModel {
        val response: FiveDayForecastModel = weatherApi.getFiveDayForecast()
        return response
    }

}