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
    private val _hotels = MutableLiveData<List<Hotel>?>()
    val hotels: MutableLiveData<List<Hotel>?> = _hotels

    init {
        viewModelScope.launch {
            when (val dataResult = hotelRepository.getHotels()) {
                is DataResult.Success -> {
                    _hotels.value = dataResult.response
                }

                is DataResult.Error ->
                   Log.i("TAG", "Couldn't get list of hotels, error ${dataResult.error}")
            }
        }
    }
}