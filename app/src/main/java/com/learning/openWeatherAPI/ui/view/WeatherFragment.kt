package com.learning.openWeatherAPI.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.learning.openWeatherAPI.databinding.FragmentWeatherBinding
import com.learning.openWeatherAPI.ui.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // viewModel
    private val weatherViewModel: WeatherViewModel by viewModels()

    private val fiveDayForecastAdapter = FiveDayForecastAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(WeatherViewModel::class.java)

        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // get the current weather from the weather
        weatherViewModel.getCurrentForecast()
        weatherViewModel.getFiveDayForecast()

        weatherViewModel.currentForecastModel.observe(this, Observer {
            binding.apply {
                currentWeatherTv.text = "Current weather in London"
                currentTempTv.text =  "Temperature:  ${it.main.temp} ºC"
                currentWindTv.text = "Wind speed: ${(it.wind.windSpeed * 3.6).roundToInt()} km/h"
                currentSkyTv.text = "Sky: ${it.weather.get(0).weatherDesc}"
                currentHumidityTv.text = "Humidity: ${it.main.humidity}%"
            }

        })

        weatherViewModel.fiveDayForecastModel.observe(this) {
            binding.apply {
                binding.fiveDayForecastRecycler.adapter = fiveDayForecastAdapter
                fiveDayForecastAdapter.setFiveDayForecastList(it)

            }
        }

        weatherViewModel.isDataLoading.observe(this) {
            binding.progressBar.isVisible = it
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

