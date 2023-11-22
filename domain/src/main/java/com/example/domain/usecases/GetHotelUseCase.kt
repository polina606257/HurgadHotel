package com.example.domain.usecases

import com.example.domain.DataResult
import com.example.domain.modul.Hotel
import com.example.domain.repository.HotelRepositoryInterface

class GetHotelUseCase(private val repository: HotelRepositoryInterface) {
    suspend operator fun invoke(): DataResult<Hotel> {
        return repository.getHotel()
    }
}