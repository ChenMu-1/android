package com.example.a2018110351_0.ui.weather

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.a2018110351_0.R
import com.example.a2018110351_0.ui.notifications.NotificationsViewModel
import com.example.a2018110351_0.ui.watch.WatchFragment
import com.example.a2018110351_0.ui.watch.WatchViewModel
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.watch_fragment.*


class WeatherFragment : Fragment() {
    companion object {
        fun newInstance() = WeatherFragment()
    }

    private lateinit var viewModel: WeatherViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.cities.observe(requireActivity(), Observer {
            val cities = it
//            val adapter = ArrayAdapter<City>(this, android.R.layout.simple_list_item_1, cities)
            val adapter = getActivity()?.let { it1 ->
                ArrayAdapter(
                    it1,
                    android.R.layout.simple_list_item_1,
                    cities
                )
            }
            listView.adapter = adapter
            listView.setOnItemClickListener { _, _, position, _ ->
                val cityCode = cities[position].city_code
                val intent = Intent(getActivity(), SecondActivity::class.java)
                intent.putExtra("city_code", cityCode)
                startActivity(intent)
            }
        })


    }

}
