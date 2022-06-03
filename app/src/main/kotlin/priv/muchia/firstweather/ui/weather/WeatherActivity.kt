package priv.muchia.firstweather.ui.weather

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import priv.muchia.firstweather.databinding.ActivityWeatherBinding
import priv.muchia.firstweather.databinding.ItemWeatherFutureBinding
import priv.muchia.firstweather.logic.model.getWeather
import priv.muchia.firstweather.toast


class WeatherActivity : AppCompatActivity() {
    lateinit var binding: ActivityWeatherBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)

        window.statusBarColor = Color.TRANSPARENT
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(binding.root)
        val locationId = intent.getStringExtra("locationId")
        val name = intent.getStringExtra("name")
        binding.currentLayout.nameTV.text = name

        binding.refreshLayout.apply {
            setColorSchemeResources(com.google.android.material.R.color.design_default_color_primary)
            setOnRefreshListener {
                getInfo(locationId)
            }
        }

        binding.currentLayout.homeBtn.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {}

            override fun onDrawerOpened(drawerView: View) {}

            override fun onDrawerClosed(drawerView: View) {}

            override fun onDrawerStateChanged(newState: Int) {
                ViewCompat.getWindowInsetsController(binding.root)
                    ?.hide(WindowInsetsCompat.Type.ime())
            }

        })

        getInfo(locationId)

        showCurrentWeather()

        showFutureWeather()

        showIndices()

    }

    fun getInfo(locationId: String?) {
        if (locationId.isNullOrEmpty()) {
            "id为空".toast()
        } else {
            viewModel.getWeather(locationId)
        }
    }

    private fun showIndices() {
        viewModel.indexLiveData.observe(this) {
            binding.refreshLayout.isRefreshing = false
            val indices = it.getOrNull()
            if (indices.isNullOrEmpty()) {
                "未查到相关指数".toast()
            } else {
                binding.indicesLayout.apply {
                    for (index in indices) {
                        when (index.type) {
                            "2" -> carIndexTv.text = index.category
                            "3" -> dressIndexTv.text = index.category
                            "5" -> ultravioletIndexTv.text = index.category
                            "9" -> coldIndexTv.text = index.category
                        }
                    }
                }
            }
        }
    }

    private fun showFutureWeather() {
        viewModel.futureLiveData.observe(this) {
            binding.refreshLayout.isRefreshing = false
            val weatherList = it.getOrNull()
            if (weatherList.isNullOrEmpty()) {
                "未查到未来天气".toast()
            } else {
                binding.futureLayout.futureLayout.removeAllViews()
                for (weather in weatherList) {
                    val itemBinding = ItemWeatherFutureBinding.inflate(layoutInflater,
                        binding.futureLayout.futureLayout,
                        false)
                    itemBinding.futureTimeTV.text = weather.fxDate
                    itemBinding.futureWeatherTv.text = weather.textDay
                    itemBinding.futureTmpTv.text = "${weather.tempMin} - ${weather.tempMax} ℃"
                    itemBinding.futureWeatherImg.setImageResource(getWeather(weather.iconDay).icon)
                    binding.futureLayout.futureLayout.addView(itemBinding.root)
                }
            }
        }
    }

    private fun showCurrentWeather() {
        viewModel.currentLiveData.observe(this) {
            binding.refreshLayout.isRefreshing = false
            val weather = it.getOrNull()
            if (null != weather) {
                binding.currentLayout.apply {
                    temperatureTV.text = "${weather.weather.temp}℃"
                    weatherTV.text = weather.weather.text
                    airTV.text = "空气指数 ${weather.air.aqi}"
                    currentLayout.setBackgroundResource(getWeather(weather.weather.icon).bg)
                }
            } else {
                "未查到相关天气".toast()
            }
        }
    }
}