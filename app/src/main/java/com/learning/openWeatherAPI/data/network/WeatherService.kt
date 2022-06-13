package com.learning.openWeatherAPI.data.network


import com.learning.openWeatherAPI.core.RetrofitHelper
import com.learning.openWeatherAPI.data.model.FiveDayForecastModel
import com.learning.openWeatherAPI.data.model.OneDayForecastModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class WeatherService {

    private val retrofit = RetrofitHelper.getRetrofit()

    private val api_key = "YOUR API KEY GOES HERE"

    suspend fun getOneDayForecast(): OneDayForecastModel{
        return withContext(Dispatchers.IO) {
            val response: Response<OneDayForecastModel> = retrofit
                .create(WeatherApiClient::class.java).getOneDayForecast(api_key)

            response.body() ?: OneDayForecastModel()
        }
    }

    suspend fun getFiveDayForecast(): FiveDayForecastModel {
        return withContext(Dispatchers.IO) {
            val response: Response<FiveDayForecastModel> = retrofit
                .create(WeatherApiClient::class.java).getFiveDayForecast(api_key)

            response.body() ?: FiveDayForecastModel()
        }
    }
}