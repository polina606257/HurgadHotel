package com.example.hurgadhotel.data.remote

import com.example.domain.modul.BookingInfo

class BookingDataSource (apiService: ApiService) {

    private val remoteService: ApiService by lazy {
        apiService
    }
    suspend fun getBookingInfo() : BookingInfo {
        return remoteService.getBookingInfo()
    }
}