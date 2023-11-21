package com.example.domain.repository

import com.example.domain.DataResult
import com.example.domain.modul.Hotel

interface HotelRepositoryInterface {
    suspend fun getHotel() : DataResult<Hotel>
}