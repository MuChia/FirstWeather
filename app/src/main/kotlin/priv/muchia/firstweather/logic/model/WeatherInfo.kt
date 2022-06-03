package priv.muchia.firstweather.logic.model

import priv.muchia.firstweather.R

/**
 * FileName: WeatherInfo
 * Author: MuChia
 * Date: 2022/6/3 14:45
 * Description:
 */
data class Weather(val info: String, val icon: Int, val bg: Int)

private val weathers = mapOf<String, Weather>(
    "100" to Weather("晴", R.drawable.ic_clear_day, R.drawable.bg_clear_day),
    "150" to Weather("晴", R.drawable.ic_clear_night, R.drawable.bg_clear_night),
    "101" to Weather("多云", R.drawable.ic_partly_cloud_day, R.drawable.bg_partly_cloudy_day),
    "102" to Weather("多云", R.drawable.ic_partly_cloud_day, R.drawable.bg_partly_cloudy_day),
    "103" to Weather("多云", R.drawable.ic_partly_cloud_day, R.drawable.bg_partly_cloudy_day),
    "151" to Weather("多云", R.drawable.ic_partly_cloud_night, R.drawable.bg_partly_cloudy_night),
    "152" to Weather("多云", R.drawable.ic_partly_cloud_night, R.drawable.bg_partly_cloudy_night),
    "153" to Weather("多云", R.drawable.ic_partly_cloud_night, R.drawable.bg_partly_cloudy_night),
    "104" to Weather("阴", R.drawable.ic_cloudy, R.drawable.bg_cloudy),
    "154" to Weather("阴", R.drawable.ic_cloudy, R.drawable.bg_cloudy),
    "305" to Weather("小雨", R.drawable.ic_light_rain, R.drawable.bg_rain),
    "309" to Weather("小雨", R.drawable.ic_light_rain, R.drawable.bg_rain),
    "306" to Weather("中雨", R.drawable.ic_moderate_rain, R.drawable.bg_rain),
    "307" to Weather("大雨", R.drawable.ic_heavy_rain, R.drawable.bg_rain),
    "308" to Weather("暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "310" to Weather("暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "311" to Weather("暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "312" to Weather("暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain),
    "302" to Weather("雷阵雨", R.drawable.ic_thunder_shower, R.drawable.bg_rain),
    "300" to Weather("雷阵雨", R.drawable.ic_thunder_shower, R.drawable.bg_rain),
    "301" to Weather("雷阵雨", R.drawable.ic_thunder_shower, R.drawable.bg_rain),
    "303" to Weather("雷阵雨", R.drawable.ic_thunder_shower, R.drawable.bg_rain),
    "304" to Weather("冰雹", R.drawable.ic_hail, R.drawable.bg_snow),
    "313" to Weather("冰雹", R.drawable.ic_hail, R.drawable.bg_snow),
    "407" to Weather("小雪", R.drawable.ic_light_snow, R.drawable.bg_snow),
    "400" to Weather("小雪", R.drawable.ic_light_snow, R.drawable.bg_snow),
    "401" to Weather("中雪", R.drawable.ic_moderate_snow, R.drawable.bg_snow),
    "408" to Weather("中雪", R.drawable.ic_moderate_snow, R.drawable.bg_snow),
    "402" to Weather("大雪", R.drawable.ic_heavy_snow, R.drawable.bg_snow),
    "409" to Weather("大雪", R.drawable.ic_heavy_snow, R.drawable.bg_snow),
    "403" to Weather("暴雪", R.drawable.ic_heavy_snow, R.drawable.bg_snow),
    "410" to Weather("暴雪", R.drawable.ic_heavy_snow, R.drawable.bg_snow),
    "404" to Weather("雨夹雪", R.drawable.ic_sleet, R.drawable.bg_rain),
    "405" to Weather("雨夹雪", R.drawable.ic_sleet, R.drawable.bg_rain),
    "406" to Weather("雨夹雪", R.drawable.ic_sleet, R.drawable.bg_rain),
    "456" to Weather("雨夹雪", R.drawable.ic_sleet, R.drawable.bg_rain),
    "457" to Weather("雨夹雪", R.drawable.ic_sleet, R.drawable.bg_rain),
    "500" to Weather("雾", R.drawable.ic_fog, R.drawable.bg_fog),
    "501" to Weather("雾", R.drawable.ic_fog, R.drawable.bg_fog),
    "509" to Weather("雾", R.drawable.ic_fog, R.drawable.bg_fog),
    "510" to Weather("雾", R.drawable.ic_fog, R.drawable.bg_fog),
    "514" to Weather("雾", R.drawable.ic_fog, R.drawable.bg_fog),
    "515" to Weather("雾", R.drawable.ic_fog, R.drawable.bg_fog),
    "502" to Weather("轻度雾霾", R.drawable.ic_light_haze, R.drawable.bg_fog),
    "511" to Weather("中度雾霾", R.drawable.ic_moderate_haze, R.drawable.bg_fog),
    "512" to Weather("重度雾霾", R.drawable.ic_heavy_haze, R.drawable.bg_fog),
    "513" to Weather("重度雾霾", R.drawable.ic_heavy_haze, R.drawable.bg_fog),
    "503" to Weather("浮尘", R.drawable.ic_fog, R.drawable.bg_fog),
    "504" to Weather("浮尘", R.drawable.ic_fog, R.drawable.bg_fog),
    "507" to Weather("浮尘", R.drawable.ic_fog, R.drawable.bg_fog),
    "508" to Weather("浮尘", R.drawable.ic_fog, R.drawable.bg_fog),
).withDefault { Weather("晴", R.drawable.ic_clear_day, R.drawable.bg_clear_day) }


fun getWeather(code: String): Weather = weathers.getValue(code)



