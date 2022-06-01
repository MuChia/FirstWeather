package priv.muchia.firstweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * FileName: WeatherApplication
 * Author: MuChia
 * Date: 2022/6/1 10:11
 * Description:
 */
class WeatherApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()

        context = applicationContext
    }
}