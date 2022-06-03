package priv.muchia.firstweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import priv.muchia.firstweather.logic.Repository

/**
 * FileName: WeatherViewModel
 * Author: MuChia
 * Date: 2022/6/2 17:07
 * Description:
 */
class WeatherViewModel: ViewModel() {
    private val weatherLiveData = MutableLiveData<String>()

    val currentLiveData = Transformations.switchMap(weatherLiveData){
        Repository.getWeathers(it)
    }

    val futureLiveData = Transformations.switchMap(weatherLiveData){
        Repository.getFutureWeather(it)
    }

    val indexLiveData = Transformations.switchMap(weatherLiveData){
        Repository.getIndices(it)
    }

    fun getWeather(location: String){
        weatherLiveData.value = location
    }
}