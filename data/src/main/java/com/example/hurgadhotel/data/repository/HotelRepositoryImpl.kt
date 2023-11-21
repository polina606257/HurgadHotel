package com.example.hurgadhotel.data.repository

import com.example.domain.DataResult
import com.example.hurgadhotel.data.remote.HotelDataSource
import com.example.domain.modul.Hotel
import com.example.domain.repository.HotelRepositoryInterface

class HotelRepositoryImpl(private val hotelDataSource: HotelDataSource) :
    HotelRepositoryInterface {
    override suspend fun getHotel(): DataResult<Hotel> {
        return try {
            val hotel = hotelDataSource.getHotel()
            DataResult.Success(hotel)
        } catch (e: Exception) {
            DataResult.Error(e.message)
        }
    }
}