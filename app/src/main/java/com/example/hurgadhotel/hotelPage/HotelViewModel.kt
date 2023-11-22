package com.example.hurgadhotel.hotelPage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.DataResult
import com.example.domain.modul.Hotel
import com.example.domain.usecases.GetHotelUseCase
import kotlinx.coroutines.launch

class HotelViewModel(private val getHotelUseCase: GetHotelUseCase) : ViewModel() {
    private val _hotel = MutableLiveData<Hotel?>()
    val hotel: LiveData<Hotel?> = _hotel

    init {
        viewModelScope.launch {
            when(val dataResult = getHotelUseCase()) {
                is DataResult.Success -> _hotel.value = dataResult.response
                is DataResult.Error ->  Log.i("TAG", "Couldn't find any hotel, error ${dataResult.error}")
            }
        }
    }
}