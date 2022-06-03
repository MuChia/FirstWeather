package priv.muchia.firstweather.logic.model

data class AirQuality(
    val code: String,
    val now: Quality,
) {
    data class Quality(
        val aqi: String,
        val category: String,
        val co: String,
        val level: String,
        val no2: String,
        val o3: String,
        val pm10: String,
        val pm2p5: String,
        val primary: String,
        val pubTime: String,
        val so2: String
    )
}