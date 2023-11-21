package com.example.hurgadhotel.hotelPage

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
            val dataResult = getHotelUseCase.execute()
            if (dataResult is DataResult.Success) {
                _hotel.value = dataResult.response
            }
        }
    }
}