package com.example.hurgadhotel.di

import com.example.hurgadhotel.data.remote.ApiRetrofitFactory.provideApiService
import com.example.hurgadhotel.data.remote.ApiRetrofitFactory.provideRetrofit
import com.example.hurgadhotel.data.remote.HotelDataSource
import com.example.domain.repository.HotelRepositoryInterface
import com.example.domain.repository.RoomRepositoryInterface
import com.example.hurgadhotel.data.remote.ApiService
import com.example.hurgadhotel.data.remote.RoomDataSource
import com.example.hurgadhotel.data.repository.HotelRepositoryImpl
import com.example.hurgadhotel.data.repository.RoomRepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {

    factory<ApiService> { provideApiService(get()) }

    single<Retrofit> { provideRetrofit() }

    factory<HotelDataSource> { HotelDataSource(apiService = get()) }

    factory<RoomDataSource> { RoomDataSource(apiService = get()) }

    single<HotelRepositoryInterface> { HotelRepositoryImpl(hotelDataSource = get()) }

    single<RoomRepositoryInterface> { RoomRepositoryImpl(roomDataSource = get()) }
}