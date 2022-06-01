package priv.muchia.firstweather.logic

import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import priv.muchia.firstweather.logic.network.WeatherNetwork


/**
 * FileName: Repository
 * Author: MuChia
 * Date: 2022/6/1 13:22
 * Description:
 */
object Repository {

    fun searchCities(location: String) = liveData(Dispatchers.IO) {
        val result = try {
            val cityResponse = WeatherNetwork.searchCities(location)
            if (cityResponse.code == "200"){
                val city = cityResponse.location
                Result.success(city)
            } else {
                Result.failure(Throwable("response code is ${cityResponse.code}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
        emit(result)
    }
}