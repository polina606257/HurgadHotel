package com.example.hurgadhotel.data.repository

import android.util.Log
import com.example.hurgadhotel.data.DataResult
import com.example.hurgadhotel.data.remote.ApiServiceDataSource
import com.example.hurgadhotel.domain.model.Hotel
import com.example.hurgadhotel.domain.model.ListRooms

class RepositoryInterfaceImpl(private val apiServiceDataSource: ApiServiceDataSource) :
    RepositoryInterface {
    override suspend fun getHotel(): DataResult<Hotel> {
        return try {
            val hotel = apiServiceDataSource.getHotel()
            DataResult.Success(hotel)
        } catch (e: Exception) {
            DataResult.Error(e.message)
        }
    }

    override suspend fun getRooms(): DataResult<ListRooms> {
        return try {
            val rooms = apiServiceDataSource.getRooms()
            DataResult.Success(rooms)
        } catch (e: Exception) {
            DataResult.Error(e.message)
        }
    }
}