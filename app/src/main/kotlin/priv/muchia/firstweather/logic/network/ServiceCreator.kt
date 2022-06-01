package priv.muchia.firstweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * FileName: ServiceCreator
 * Author: MuChia
 * Date: 2022/6/1 12:28
 * Description:
 */
object ServiceCreator {
    private const val CITY_VERSION = "v2"
    private const val CITY_BASE_URL = "https://geoapi.qweather.com/$CITY_VERSION/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(CITY_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //为了不对外暴露retrofit对象设为private inline函数中不可以调用private的对象 用下面的函数作为中介
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    inline fun <reified T> create(): T = create(T::class.java)
}