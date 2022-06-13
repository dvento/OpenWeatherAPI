package com.learning.openWeatherAPI.data.model

data class FiveDayForecastModel (
    /*
     "list" is one of the fields that the Weather API returns in the response,
     that's why we created a separate data class for this "list"; it couldn't be retrieved
     in the WeatherApiClient as "Response<List<OneDayForecastModel>>"

     */
    val list: List<OneDayForecastModel> = emptyList()

)