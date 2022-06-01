package priv.muchia.firstweather

import android.widget.Toast

/**
 * FileName: Utils
 * Author: MuChia
 * Date: 2022/6/1 10:23
 * Description:
 */
fun String.toast(duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(WeatherApplication.context, this, duration).show()
}

fun Int.toast(duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(WeatherApplication.context, this, duration).show()
}