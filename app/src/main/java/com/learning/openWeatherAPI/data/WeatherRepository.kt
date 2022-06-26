package com.learning.openWeatherAPI.data

import com.learning.openWeatherAPI.data.model.FiveDayForecastModel
import com.learning.openWeatherAPI.data.model.OneDayForecastModel
import com.learning.openWeatherAPI.data.network.WeatherService
import javax.inject.Inject
import javax.inject.Singleton


class WeatherRepository @Inject constructor(
    private val weatherApi:WeatherService
) {

    suspend fun getOneDayForecast(): OneDayForecastModel{
        val response: OneDayForecastModel = weatherApi.getOneDayForecast()
        /*
        Mocked forecast provider, just to test before the implementation of retrofit working client
        OneDayForecastProvider
         */
        return response
    }

    suspend fun getFiveDayForecast(): FiveDayForecastModel {
        val response: FiveDayForecastModel = weatherApi.getFiveDayForecast()
        return response
    }

}