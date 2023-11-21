package com.example.hurgadhotel.data.repository

import com.example.domain.DataResult
import com.example.domain.modul.ListRooms
import com.example.domain.repository.RoomRepositoryInterface
import com.example.hurgadhotel.data.remote.RoomDataSource

class RoomRepositoryImpl(private val roomDataSource: RoomDataSource) : RoomRepositoryInterface {
    override suspend fun getRooms(): DataResult<ListRooms> {
        return try {
            val rooms = roomDataSource.getRooms()
            DataResult.Success(rooms)
        } catch (e: Exception) {
            DataResult.Error(e.message)
        }
    }
}