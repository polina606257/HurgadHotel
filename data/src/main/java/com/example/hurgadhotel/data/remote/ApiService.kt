package com.example.hurgadhotel.data.remote

import com.example.hurgadhotel.domain.model.Hotel
import com.example.hurgadhotel.domain.model.ListRooms
import retrofit2.http.GET
interface ApiService {
    @GET("d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotel() : Hotel
    @GET("8b532701-709e-4194-a41c-1a903af00195")
    suspend fun getRooms() : ListRooms
}