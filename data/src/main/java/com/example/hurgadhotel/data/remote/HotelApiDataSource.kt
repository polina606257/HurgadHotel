package com.example.hurgadhotel.data.remote

import com.example.hurgadhotel.domain.model.Hotel

class HotelApiDataSource(hotelApi: HotelApi) {
    private val remoteService: HotelApi by lazy {
        hotelApi
    }
    suspend fun getHotel() : Hotel {
        return remoteService.getHotel()
    }
}