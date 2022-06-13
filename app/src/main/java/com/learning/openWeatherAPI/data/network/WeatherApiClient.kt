package com.learning.openWeatherAPI.data.network

import com.learning.openWeatherAPI.data.model.FiveDayForecastModel
import com.learning.openWeatherAPI.data.model.OneDayForecastModel
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApiClient {

    // get current weather, location hardcoded
    @GET("weather?q=London,uk&units=metric")
    suspend fun getOneDayForecast(@Query("APPID") api_key:String): Response<OneDayForecastModel>

    // get 5 day forecast weather, location hardcoded
    @GET("forecast?q=London,uk&&units=metric")
    suspend fun getFiveDayForecast(@Query("APPID") api_key:String): Response<FiveDayForecastModel>

}