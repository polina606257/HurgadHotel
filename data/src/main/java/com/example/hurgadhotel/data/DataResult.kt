package com.example.hurgadhotel.data

import com.example.hurgadhotel.domain.model.Hotel

sealed class DataResult<out R> {
    data class Success <out T>(val response: T) : DataResult<T>()
    data class Error(val error: String?) : DataResult<Nothing>()
}
