package com.example.hurgadhotel.bookingPage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.DataResult
import com.example.domain.modul.BookingInfo
import com.example.domain.usecases.GetBookingInfoUseCase
import kotlinx.coroutines.launch

class BookingViewModel(val getBookingInfoUseCase: GetBookingInfoUseCase) : ViewModel() {
    private val _bookingInfo = MutableLiveData<BookingInfo?>()
    val bookingInfo: LiveData<BookingInfo?> = _bookingInfo

    init {
        viewModelScope.launch {
            when(val dataResult = getBookingInfoUseCase()) {
                is DataResult.Success -> _bookingInfo.value = dataResult.response
                is DataResult.Error ->  Log.i("TAG", "Couldn't find any hotel, error ${dataResult.error}")
            }
        }
    }
}