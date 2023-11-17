package com.example.hurgadhotel.data.repository

import com.example.hurgadhotel.data.DataResult
import com.example.hurgadhotel.data.remote.HotelApiDataSource
import com.example.hurgadhotel.domain.model.Hotel

class HotelRepositoryImpl(private val hotelApiDataSource: HotelApiDataSource) : HotelRepository{
    override suspend fun getHotel(): DataResult<Hotel> {
        return try {
            val hotel = hotelApiDataSource.getHotel()
            DataResult.Success(hotel)
        } catch (e: Exception) {
            DataResult.Error(e.message)
        }
    }
}