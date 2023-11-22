package com.example.domain.usecases

import com.example.domain.DataResult
import com.example.domain.modul.BookingInfo
import com.example.domain.repository.BookingRepositoryInterface

class GetBookingInfoUseCase(private val repository: BookingRepositoryInterface) {
    suspend operator fun invoke(): DataResult<BookingInfo> {
        return repository.getBookingInfo()
    }
}