package com.example.hurgadhotel.di

import com.example.domain.usecases.GetBookingInfoUseCase
import com.example.domain.usecases.GetHotelUseCase
import com.example.domain.usecases.GetRoomsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetHotelUseCase(repository = get()) }
    factory { GetRoomsUseCase(repository = get()) }
    factory { GetBookingInfoUseCase(repository = get()) }
}