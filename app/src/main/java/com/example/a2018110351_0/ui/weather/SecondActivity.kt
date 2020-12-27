package com.example.a2018110351_0.ui.weather

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a2018110351_0.R
import com.example.weather.weather.Forecast
import com.example.weather.weather.weather
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second.listView

class SecondActivity : AppCompatActivity() {

    val baseURL = "http://t.weather.itboy.net/api/weather/city/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val cityCode = intent.getStringExtra("city_code")
        val queue = Volley.newRequestQueue(this)
        val stringRuest = StringRequest(baseURL+cityCode,{
            val gson = Gson()
            val WeatherType = object : TypeToken<weather>() {}.type
            val weather = gson.fromJson<weather>(it,WeatherType)

            tv_city.text = weather.cityInfo.city
            tv_province.text = weather.cityInfo.parent
            tv_shidu.text = weather.data.shidu
            tv_wendu.text = weather.data.wendu

            val firstDay = weather.data.forecast.first()
            when(firstDay.type){
                "晴" -> imageView.setImageResource(R.drawable.sun)
                "阴" -> imageView.setImageResource(R.drawable.cloud)
                "多云" -> imageView.setImageResource(R.drawable.mcloud)
                "小雨" -> imageView.setImageResource(R.drawable.rain)
                else -> imageView.setImageResource(R.drawable.thunder)
            }

            val adapter = ArrayAdapter<Forecast>(this,android.R.layout.simple_list_item_1,weather.data.forecast)
            listView.adapter = adapter


        },{

        })
        queue.add(stringRuest)

    }
}