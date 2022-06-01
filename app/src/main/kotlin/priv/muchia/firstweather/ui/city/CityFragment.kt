package priv.muchia.firstweather.ui.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import priv.muchia.firstweather.R
import priv.muchia.firstweather.ui.BaseFragment

/**
 * FileName: CityFragment
 * Author: MuChia
 * Date: 2022/6/1 14:23
 * Description:
 */
class CityFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_city, container, false)
    }
}