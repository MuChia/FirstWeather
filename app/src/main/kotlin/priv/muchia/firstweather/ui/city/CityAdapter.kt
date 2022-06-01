package priv.muchia.firstweather.ui.city

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import priv.muchia.firstweather.R
import priv.muchia.firstweather.logic.model.Location

/**
 * FileName: CityAdapter
 * Author: MuChia
 * Date: 2022/6/1 18:49
 * Description:
 */
class CityAdapter(private val context: Context, val cities: List<Location>) :

    RecyclerView.Adapter<CityAdapter.CityViewHolder>() {
    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTv: AppCompatTextView = itemView.findViewById(R.id.cityName_tv)
        val addressTv: AppCompatTextView = itemView.findViewById(R.id.cityAdr_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_city, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cities[position]
        holder.nameTv.text = city.name
        holder.addressTv.text = city.country.plus(city.adm1).plus(city.adm2)
    }

    override fun getItemCount() = cities.size

}