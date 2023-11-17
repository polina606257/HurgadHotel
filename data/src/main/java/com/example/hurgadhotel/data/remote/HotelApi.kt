package com.example.hurgadhotel.data.remote

import com.example.hurgadhotel.domain.model.Hotel
import retrofit2.http.GET
interface HotelApi {
    @GET("d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotel() : Hotel
}