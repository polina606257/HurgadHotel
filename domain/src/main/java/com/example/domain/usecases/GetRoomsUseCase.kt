package com.example.domain.usecases

import android.util.Log
import com.example.domain.DataResult
import com.example.domain.modul.ListRooms
import com.example.domain.repository.RoomRepositoryInterface

class GetRoomsUseCase(val repository: RoomRepositoryInterface) {
    suspend operator fun invoke(): DataResult<ListRooms> {
        return repository.getRooms()
    }
}