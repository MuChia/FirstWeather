package priv.muchia.firstweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * FileName: WeatherNetwork
 * Author: MuChia
 * Date: 2022/6/1 12:41
 * Description:
 */
object WeatherNetwork {
    private val cityService = CityServiceCreator.create<CityService>()
    suspend fun searchCities(location: String) = cityService.searchCities(location).await()

    private val weatherService = WeatherServiceCreator.create<WeatherService>()
    suspend fun getCurrentWeather(locationId: String) = weatherService.getCurrentWeather(locationId).await()
    suspend fun getFutureWeather(locationId: String) = weatherService.getFutureWeather(locationId).await()
    suspend fun getIndices(locationId: String) = weatherService.getIndices(locationId).await()
    suspend fun getAirQuality(locationId: String) = weatherService.getAirQuality(locationId).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine {
            enqueue((object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (null != body) it.resume(body)
                    else it.resumeWithException(RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    it.resumeWithException(t)
                }
            }))
        }
    }
}