package com.example.domain.usecases

import android.util.Log
import com.example.domain.DataResult
import com.example.domain.modul.Hotel
import com.example.domain.repository.HotelRepositoryInterface

class GetHotelUseCase(private val repository: HotelRepositoryInterface) {
    suspend fun execute(): DataResult<Hotel> {
        return when (val dataResult = repository.getHotel()) {
            is DataResult.Success -> {
                DataResult.Success(dataResult.response)
            }

            is DataResult.Error -> {
                Log.i("TAG", "Couldn't find hotel, error ${dataResult.error}")
                DataResult.Error(dataResult.error)
            }
        }
    }
}