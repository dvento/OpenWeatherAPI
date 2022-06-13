package com.learning.openWeatherAPI.domain

import com.learning.openWeatherAPI.data.WeatherRepository
import com.learning.openWeatherAPI.data.model.OneDayForecastModel

class GetOneDayForecastUseCase() {

    private val repo = WeatherRepository()

    suspend operator fun invoke(): OneDayForecastModel {
        return repo.getOneDayForecast()
    }

}