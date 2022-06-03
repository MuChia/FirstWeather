package priv.muchia.firstweather.logic.model

data class Indices(
    val code: String,
    val daily: List<Daily>,
) {
    data class Daily(
        val category: String,
        val date: String,
        val level: String,
        val name: String,
        val text: String,
        val type: String
    )
}