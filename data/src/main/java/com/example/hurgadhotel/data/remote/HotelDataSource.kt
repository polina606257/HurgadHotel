package com.example.hurgadhotel.data.remote

import com.example.domain.modul.Hotel

class HotelDataSource(apiService: ApiService) {

    private val remoteService: ApiService by lazy {
        apiService
    }
    suspend fun getHotel(): Hotel {
        return remoteService.getHotel()
    }
}