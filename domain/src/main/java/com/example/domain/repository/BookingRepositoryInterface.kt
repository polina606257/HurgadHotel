package com.example.domain.repository

import com.example.domain.DataResult
import com.example.domain.modul.BookingInfo

interface BookingRepositoryInterface {
    suspend fun getBookingInfo() : DataResult<BookingInfo>
}