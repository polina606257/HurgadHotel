package com.example.hurgadhotel.data

import com.example.hurgadhotel.domain.model.Hotel

sealed class DataResult<out R> {
    data class Success(val response: Hotel) : DataResult<Hotel>()
    data class Error(val error: String?) : DataResult<Nothing>()
}
