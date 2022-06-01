package priv.muchia.firstweather.ui.city

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import priv.muchia.firstweather.R
import priv.muchia.firstweather.databinding.FragmentCityBinding
import priv.muchia.firstweather.toast
import priv.muchia.firstweather.ui.BaseFragment

/**
 * FileName: CityFragment
 * Author: MuChia
 * Date: 2022/6/1 14:23
 * Description:
 */
class CityFragment : BaseFragment() {
    private val viewModel: CityViewModel by viewModels()
    private lateinit var binding: FragmentCityBinding
    private lateinit var adapter: CityAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCityBinding.inflate(inflater, container, false)
        context ?: return binding.root

        adapter = CityAdapter(requireContext(), viewModel.cityList)
        binding.cityRecyclerView.also {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = adapter
        }

        binding.searchEditText.addTextChangedListener {
            val content = it.toString()
            if (content.isNotEmpty()) {
                viewModel.searchCities(content)
            } else {
                binding.cityRecyclerView.visibility = View.GONE
                binding.bgImage.visibility = View.VISIBLE
                viewModel.cityList.clear()
                adapter.notifyDataSetChanged()
            }
        }

        viewModel.cityLiveData.observe(viewLifecycleOwner) {
            val cities = it.getOrNull()
            if (null != cities) {
                binding.cityRecyclerView.visibility = View.VISIBLE
                binding.bgImage.visibility = View.GONE
                viewModel.cityList.clear()
                viewModel.cityList.addAll(cities)
                adapter.notifyDataSetChanged()
            } else {
                "未能查询到任何地点".toast()
                it.exceptionOrNull()?.printStackTrace()
            }
        }

        return binding.root
    }

}