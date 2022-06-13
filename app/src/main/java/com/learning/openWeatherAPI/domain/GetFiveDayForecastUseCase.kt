package com.learning.openWeatherAPI.domain

import com.learning.openWeatherAPI.data.WeatherRepository
import com.learning.openWeatherAPI.data.model.OneDayForecastModel

class GetFiveDayForecastUseCase {

    private val repo = WeatherRepository()

    suspend operator fun invoke(): List<OneDayForecastModel> {
        return repo.getFiveDayForecast().list
    }

}
