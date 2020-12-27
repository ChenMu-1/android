package com.example.a2018110351_0.ui.weather

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.a2018110351_0.R
import kotlinx.android.synthetic.main.activity_second.*


class WeatherFragment : Fragment() {

    private lateinit var WeatherViewModel: WeatherViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        WeatherViewModel =
            ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_weather, container, false)
        WeatherViewModel.cities.observe(requireActivity(), Observer {
            val cities = it
            val adapter = ArrayAdapter<City>(this, android.R.layout.simple_list_item_1, cities)
            listView.adapter = adapter
            listView.setOnItemClickListener { _, _, position, _ ->
                val cityCode = cities[position].city_code
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("city_code", cityCode)
                startActivity(intent)
            }

        })
        return root
    }
}