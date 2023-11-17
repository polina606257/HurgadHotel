package com.example.hurgadhotel.hotelPage

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hurgadhotel.data.DataResult
import com.example.hurgadhotel.data.repository.RepositoryInterface
import com.example.hurgadhotel.domain.model.Hotel
import kotlinx.coroutines.launch

class HotelViewModel(private val repository: RepositoryInterface) : ViewModel() {
    private val _hotel = MutableLiveData<Hotel?>()
    val hotel: MutableLiveData<Hotel?> = _hotel

    init {
        viewModelScope.launch {
            when (val dataResult = repository.getHotel()) {
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