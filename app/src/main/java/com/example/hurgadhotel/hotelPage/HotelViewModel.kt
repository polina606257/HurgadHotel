package com.example.hurgadhotel.hotelPage

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hurgadhotel.data.DataResult
import com.example.hurgadhotel.data.repository.HotelRepository
import com.example.hurgadhotel.domain.model.Hotel
import kotlinx.coroutines.launch

class HotelViewModel(private val hotelRepository: HotelRepository) : ViewModel() {
    private val _hotel = MutableLiveData<Hotel>()
    val hotel: MutableLiveData<Hotel> = _hotel

    init {
        viewModelScope.launch {
            when (val dataResult = hotelRepository.getHotel()) {
                is DataResult.Success -> {
                    _hotel.value = dataResult.response
                }

                is DataResult.Error ->
                   Log.i("TAG", "Couldn't find hotel, error ${dataResult.error}")

                else -> {
                    Log.i("TAG", "something went wrong")
                }
            }
        }
    }
}