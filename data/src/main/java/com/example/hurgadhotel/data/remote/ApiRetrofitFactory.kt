package com.example.hurgadhotel.data.remote

import com.example.hurgadhotel.data.Config
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRetrofitFactory {
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    fun provideHotelApi(retrofit: Retrofit): HotelApi = retrofit.create(HotelApi::class.java)
}