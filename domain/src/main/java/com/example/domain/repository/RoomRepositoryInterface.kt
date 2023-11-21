package com.example.domain.repository

import com.example.domain.DataResult
import com.example.domain.modul.ListRooms

interface RoomRepositoryInterface {
    suspend fun getRooms() : DataResult<ListRooms>
}