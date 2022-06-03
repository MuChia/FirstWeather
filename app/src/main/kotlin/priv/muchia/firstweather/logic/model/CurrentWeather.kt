package priv.muchia.firstweather.logic.model

data class CurrentWeather(
    val code: String,
    val now: Weather,
) {
    data class Weather(
        val cloud: String,
        val dew: String,
        val feelsLike: String,
        val humidity: String,
        val icon: String,
        val obsTime: String,
        val precip: String,
        val pressure: String,
        val temp: String,
        val text: String,
        val vis: String,
        val wind360: String,
        val windDir: String,
        val windScale: String,
        val windSpeed: String
    )
}