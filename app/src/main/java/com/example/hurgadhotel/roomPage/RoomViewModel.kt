package com.example.hurgadhotel.roomPage

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hurgadhotel.data.DataResult
import com.example.hurgadhotel.data.repository.RepositoryInterface
import com.example.hurgadhotel.domain.model.ListRooms
import kotlinx.coroutines.launch

class RoomViewModel(repository: RepositoryInterface) : ViewModel() {
    private val _rooms = MutableLiveData<ListRooms?>()
    val rooms: MutableLiveData<ListRooms?> = _rooms

    init {
        viewModelScope.launch {
            when (val dataResult = repository.getRooms()) {
                is DataResult.Success -> {
                    _rooms.value = dataResult.response
                }

                is DataResult.Error ->
                    Log.i("TAG", "Couldn't find any rooms, error ${dataResult.error}")

                else -> {
                    Log.i("TAG", "something went wrong")
                }
            }
        }
    }
}