package com.example.hurgadhotel.data.remote

import com.example.domain.modul.BookingInfo
import com.example.domain.modul.Hotel
import com.example.domain.modul.ListRooms
import retrofit2.http.GET
interface ApiService {
    @GET("d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotel() : Hotel

    @GET("8b532701-709e-4194-a41c-1a903af00195")
    suspend fun getRooms() : ListRooms

    @GET("63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun getBookingInfo() : BookingInfo
}