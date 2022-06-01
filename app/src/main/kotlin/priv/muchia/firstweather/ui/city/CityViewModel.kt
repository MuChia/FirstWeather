package priv.muchia.firstweather.ui.city

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import priv.muchia.firstweather.logic.Repository
import priv.muchia.firstweather.logic.model.Location

/**
 * FileName: CityViewModel
 * Author: MuChia
 * Date: 2022/6/1 14:01
 * Description:
 */
class CityViewModel: ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val cityList = ArrayList<Location>()

    val cityLiveData = Transformations.switchMap(searchLiveData){
        Log.d("switchMap", it)
        Repository.searchCities(it)
    }

    fun searchCities(location: String){
        searchLiveData.value = location
        Log.d("cityViewModel", location)
    }
}