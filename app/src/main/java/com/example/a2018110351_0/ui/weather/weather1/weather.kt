package com.example.weather.weather

data class weather(
    val cityInfo: CityInfo,
    val `data`: Data,
    val date: String,
    val message: String,
    val status: Int,
    val time: String
)