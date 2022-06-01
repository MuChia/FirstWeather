package priv.muchia.firstweather.logic.network

import priv.muchia.firstweather.Q_KEY
import priv.muchia.firstweather.logic.model.CityInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * FileName: CityService
 * Author: MuChia
 * Date: 2022/6/1 12:09
 * Description:
 */
interface CityService {

    @GET("city/lookup?key=$Q_KEY")
    fun searchCities(@Query("location") location: String): Call<CityInfo>
}