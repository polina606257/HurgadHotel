package com.example.hurgadhotel.data.repository

import com.example.domain.DataResult
import com.example.domain.modul.BookingInfo
import com.example.domain.repository.BookingRepositoryInterface
import com.example.hurgadhotel.data.remote.BookingDataSource

class BookingRepositoryImpl(private val bookingDataSource: BookingDataSource) :
    BookingRepositoryInterface {
    override suspend fun getBookingInfo(): DataResult<BookingInfo> {
        return try {
            val bookingInfo = bookingDataSource.getBookingInfo()
            DataResult.Success(bookingInfo)
        } catch (e: Exception) {
            DataResult.Error(e.message)
        }
    }
}