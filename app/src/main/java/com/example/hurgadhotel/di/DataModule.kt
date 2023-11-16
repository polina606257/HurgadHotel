package com.example.hurgadhotel.di

import com.example.hurgadhotel.data.remote.ApiRetrofitFactory.provideHotelApi
import com.example.hurgadhotel.data.remote.ApiRetrofitFactory.provideRetrofit
import com.example.hurgadhotel.data.remote.HotelApiDataSource
import com.example.hurgadhotel.data.repository.HotelRepository
import com.example.hurgadhotel.data.repository.HotelRepositoryImpl
import org.koin.dsl.module

val dataModule = module {

    factory { provideHotelApi(get()) }

    single { provideRetrofit() }

    factory<HotelApiDataSource> { HotelApiDataSource(hotelApi = get()) }

    single<HotelRepository> { HotelRepositoryImpl(hotelApiDataSource = get()) }
}