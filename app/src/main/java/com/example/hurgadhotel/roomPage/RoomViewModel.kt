package com.example.hurgadhotel.roomPage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.DataResult
import com.example.domain.modul.ListRooms
import com.example.domain.usecases.GetRoomsUseCase
import kotlinx.coroutines.launch

class RoomViewModel(val getRoomsUseCase: GetRoomsUseCase) : ViewModel() {
    private val _rooms = MutableLiveData<ListRooms?>()
    val rooms: MutableLiveData<ListRooms?> = _rooms

    init {
        viewModelScope.launch {
            val dataResult = getRoomsUseCase.execute()
            if(dataResult is DataResult.Success) {
                _rooms.value = dataResult.response
            }
        }
    }
}