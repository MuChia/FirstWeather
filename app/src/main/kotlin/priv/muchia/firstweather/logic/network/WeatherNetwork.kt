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
    private val cityService = ServiceCreator.create<CityService>()
    suspend fun searchCities(location: String) = cityService.searchCities(location).await()

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