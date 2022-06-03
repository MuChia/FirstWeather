package priv.muchia.firstweather.logic

import android.util.Log
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import priv.muchia.firstweather.logic.model.WeatherAndAir
import priv.muchia.firstweather.logic.network.WeatherNetwork
import kotlin.coroutines.CoroutineContext


/**
 * FileName: Repository
 * Author: MuChia
 * Date: 2022/6/1 13:22
 * Description:
 */
object Repository {
    fun searchCities(location: String) = fire(Dispatchers.IO) {
        val cityResponse = WeatherNetwork.searchCities(location)
        if (cityResponse.code == "200") {
            val city = cityResponse.location
            Result.success(city)
        } else {
            Result.failure(Throwable("response code is ${cityResponse.code}"))
        }
    }

    fun getCurrentWeather(locationId: String) = fire(Dispatchers.IO) {
        val weatherResponse = WeatherNetwork.getCurrentWeather(locationId)
        if (weatherResponse.code == "200") {
            val weather = weatherResponse.now
            Result.success(weather)
        } else {
            Result.failure(Throwable("response code is ${weatherResponse.code}"))
        }
    }

    fun getFutureWeather(locationId: String) = fire(Dispatchers.IO) {
        val weatherResponse = WeatherNetwork.getFutureWeather(locationId)
        if (weatherResponse.code == "200") {
            val weather = weatherResponse.daily
            Result.success(weather)
        } else {
            Result.failure(Throwable("response code is ${weatherResponse.code}"))
        }
    }

    fun getIndices(locationId: String) = fire(Dispatchers.IO) {
        val indexResponse = WeatherNetwork.getIndices(locationId)
        if (indexResponse.code == "200") {
            val index = indexResponse.daily
            Result.success(index)
        } else {
            Result.failure(Throwable("response code is ${indexResponse.code}"))
        }
    }

    fun getWeathers(locationId: String) = fire(Dispatchers.IO) {
        coroutineScope {
            val defCurrentResponse = async {
                WeatherNetwork.getCurrentWeather(locationId)
            }
            val defAirResponse = async {
                WeatherNetwork.getAirQuality(locationId)
            }
            val currentResponse = defCurrentResponse.await()
            val airResponse = defAirResponse.await()

            if (currentResponse.code == "200" && airResponse.code == "200") {
                val weatherAndAir = WeatherAndAir(currentResponse.now, airResponse.now)
                Result.success(weatherAndAir)
            } else {
                Result.failure(Throwable(
                    "weather code is ${currentResponse.code}," +
                        " air code is ${airResponse.code}")
                )
            }
        }
    }


    fun getAirQuality(locationId: String) = fire(Dispatchers.IO) {
        val airResponse = WeatherNetwork.getAirQuality(locationId)
        if (airResponse.code == "200") {
            val air = airResponse.now
            Result.success(air)
        } else {
            Result.failure(Throwable("response code is ${airResponse.code}"))
        }
    }

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure(e)
            }
            emit(result)
        }
}