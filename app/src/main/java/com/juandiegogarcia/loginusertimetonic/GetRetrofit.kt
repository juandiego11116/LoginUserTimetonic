package com.juandiegogarcia.loginusertimetonic

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://timetonic.com/live/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}