package com.example.hurgadhotel.data.remote

import com.example.hurgadhotel.domain.model.Hotel

class HotelApiDataSource(hotelApi: HotelApi) {
    private val remoteService: HotelApi by lazy {
        hotelApi
    }
    suspend fun getHotels() : List<Hotel> {
        return remoteService.getHotels()
    }
}