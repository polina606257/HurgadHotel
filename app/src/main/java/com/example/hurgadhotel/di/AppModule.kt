package com.example.hurgadhotel.di

import com.example.hurgadhotel.hotelPage.HotelViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<HotelViewModel> {
        HotelViewModel(hotelRepository = get())
    }
}