package com.example.a2018110351_0.ui.weather.weather1

data class weather(
    val cityInfo: CityInfo,
    val `data`: Data,
    val date: String,
    val message: String,
    val status: Int,
    val time: String
)