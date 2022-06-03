package priv.muchia.firstweather.logic.network

import priv.muchia.firstweather.Q_KEY
import priv.muchia.firstweather.logic.model.AirQuality
import priv.muchia.firstweather.logic.model.CurrentWeather
import priv.muchia.firstweather.logic.model.FutureWeather
import priv.muchia.firstweather.logic.model.Indices
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * FileName: CityService
 * Author: MuChia
 * Date: 2022/6/1 12:09
 * Description:
 */
interface WeatherService {

    @GET("weather/now?key=$Q_KEY")
    fun getCurrentWeather(@Query("location") locationId: String): Call<CurrentWeather>

    @GET("weather/7d?key=$Q_KEY")
    fun getFutureWeather(@Query("location") locationId: String): Call<FutureWeather>

    @GET("indices/1d?key=$Q_KEY&type=2,3,5,9")
    fun getIndices(@Query("location") locationId: String): Call<Indices>

    @GET("air/now?key=$Q_KEY")
    fun getAirQuality(@Query("location") locationId: String): Call<AirQuality>
}