package com.example.hurgadhotel.data.remote

import android.util.Log
import com.example.hurgadhotel.domain.model.Hotel
import com.example.hurgadhotel.domain.model.ListRooms

class ApiServiceDataSource(apiService: ApiService) {
    private val remoteService: ApiService by lazy {
        apiService
    }

    suspend fun getHotel(): Hotel {
        return remoteService.getHotel()
    }

    suspend fun getRooms(): ListRooms {
        val data = remoteService.getRooms()
        return data
    }
}