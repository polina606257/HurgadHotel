package com.example.domain.usecases

import android.util.Log
import com.example.domain.DataResult
import com.example.domain.modul.ListRooms
import com.example.domain.repository.RoomRepositoryInterface

class GetRoomsUseCase(val repository: RoomRepositoryInterface) {
    suspend fun execute(): DataResult<ListRooms> {
        return when (val dataResult = repository.getRooms()) {
            is DataResult.Success -> {
                DataResult.Success(dataResult.response)
            }

            is DataResult.Error -> {
                Log.i("TAG", "Couldn't find any rooms, error ${dataResult.error}")
                DataResult.Error(dataResult.error)
            }
        }
    }
}