package com.example.hurgadhotel.di

import com.example.hurgadhotel.hotelPage.HotelViewModel
import com.example.hurgadhotel.roomPage.RoomViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<HotelViewModel> {
        HotelViewModel(repository = get())
    }

    viewModel<RoomViewModel> {
        RoomViewModel(repository = get())
    }
}