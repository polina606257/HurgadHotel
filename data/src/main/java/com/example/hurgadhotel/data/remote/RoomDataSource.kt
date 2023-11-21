package com.example.hurgadhotel.data.remote

import com.example.domain.modul.ListRooms

class RoomDataSource(apiService: ApiService) {

    private val remoteService: ApiService by lazy {
        apiService
    }
    suspend fun getRooms(): ListRooms {
        return remoteService.getRooms()
    }
}