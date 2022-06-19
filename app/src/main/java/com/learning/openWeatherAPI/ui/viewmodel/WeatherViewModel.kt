package com.learning.openWeatherAPI.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.openWeatherAPI.data.model.OneDayForecastModel
import com.learning.openWeatherAPI.domain.GetFiveDayForecastUseCase
import com.learning.openWeatherAPI.domain.GetOneDayForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    val getOneDayForecastUseCase: GetOneDayForecastUseCase,
    val getFiveDayForecastUseCase: GetFiveDayForecastUseCase
) : ViewModel() {

    val currentForecastModel = MutableLiveData<OneDayForecastModel>()
    val fiveDayForecastModel = MutableLiveData<List<OneDayForecastModel>>()
    val isDataLoading = MutableLiveData<Boolean>()

    fun getCurrentForecast(){
        viewModelScope.launch {
            isDataLoading.postValue(true)

            val currentOneDayForecast = getOneDayForecastUseCase()

            currentForecastModel.postValue(currentOneDayForecast).apply {
                isDataLoading.postValue(false)
            }
        }
    }

    fun getFiveDayForecast() {
        viewModelScope.launch{
            isDataLoading.postValue(true)

            val fiveDayForecast = getFiveDayForecastUseCase()

            fiveDayForecastModel.postValue(fiveDayForecast).apply {
                isDataLoading.postValue(false)
            }

        }
    }

}