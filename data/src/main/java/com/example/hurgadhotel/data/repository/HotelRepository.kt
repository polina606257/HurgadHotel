package com.example.hurgadhotel.data.repository

import com.example.hurgadhotel.data.DataResult
import com.example.hurgadhotel.domain.model.Hotel

interface HotelRepository {
    suspend fun getHotel() : DataResult<Hotel>
}