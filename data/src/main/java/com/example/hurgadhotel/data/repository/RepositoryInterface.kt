package com.example.hurgadhotel.data.repository

import com.example.hurgadhotel.data.DataResult
import com.example.hurgadhotel.domain.model.Hotel
import com.example.hurgadhotel.domain.model.ListRooms
import com.example.hurgadhotel.domain.model.Room

interface RepositoryInterface {
    suspend fun getHotel() : DataResult<Hotel>
    suspend fun getRooms() : DataResult<ListRooms>
}