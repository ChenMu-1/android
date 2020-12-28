package com.example.a2018110351_0.ui.weather.weather1

data class Forecast(
    val aqi: Int,
    val date: String,
    val fl: String,
    val fx: String,
    val high: String,
    val low: String,
    val notice: String,
    val sunrise: String,
    val sunset: String,
    val type: String,
    val week: String,
    val ymd: String
){
    override fun toString():String{
        return "$week: $low-$high:$type"
    }
}