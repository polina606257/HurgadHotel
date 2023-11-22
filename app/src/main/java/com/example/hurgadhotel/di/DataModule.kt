package com.example.hurgadhotel.di

import com.example.domain.modul.BookingInfo
import com.example.domain.repository.BookingRepositoryInterface
import com.example.hurgadhotel.data.remote.ApiRetrofitFactory.provideApiService
import com.example.hurgadhotel.data.remote.ApiRetrofitFactory.provideRetrofit
import com.example.hurgadhotel.data.remote.HotelDataSource
import com.example.domain.repository.HotelRepositoryInterface
import com.example.domain.repository.RoomRepositoryInterface
import com.example.hurgadhotel.data.remote.ApiService
import com.example.hurgadhotel.data.remote.BookingDataSource
import com.example.hurgadhotel.data.remote.RoomDataSource
import com.example.hurgadhotel.data.repository.BookingRepositoryImpl
import com.example.hurgadhotel.data.repository.HotelRepositoryImpl
import com.example.hurgadhotel.data.repository.RoomRepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {

    factory<ApiService> { provideApiService(get()) }
    single<Retrofit> { provideRetrofit() }

    factory<HotelDataSource> { HotelDataSource(apiService = get()) }
    factory<RoomDataSource> { RoomDataSource(apiService = get()) }
    factory<BookingDataSource> { BookingDataSource(apiService = get()) }

    single<HotelRepositoryInterface> { HotelRepositoryImpl(hotelDataSource = get()) }
    single<RoomRepositoryInterface> { RoomRepositoryImpl(roomDataSource = get()) }
    single<BookingRepositoryInterface> { BookingRepositoryImpl(bookingDataSource = get()) }
}