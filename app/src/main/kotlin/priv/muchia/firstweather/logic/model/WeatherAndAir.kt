package priv.muchia.firstweather.logic.model

/**
 * FileName: WeatherAndAir
 * Author: MuChia
 * Date: 2022/6/2 16:47
 * Description:
 */
data class WeatherAndAir(
    val weather: CurrentWeather.Weather,
    val air: AirQuality.Quality
    )