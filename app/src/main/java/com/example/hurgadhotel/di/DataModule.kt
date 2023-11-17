package com.example.hurgadhotel.di

import com.example.hurgadhotel.data.remote.ApiRetrofitFactory.provideApiService
import com.example.hurgadhotel.data.remote.ApiRetrofitFactory.provideRetrofit
import com.example.hurgadhotel.data.remote.ApiServiceDataSource
import com.example.hurgadhotel.data.repository.RepositoryInterface
import com.example.hurgadhotel.data.repository.RepositoryInterfaceImpl
import org.koin.dsl.module

val dataModule = module {

    factory { provideApiService(get()) }

    single { provideRetrofit() }

    factory<ApiServiceDataSource> { ApiServiceDataSource(apiService = get()) }

    single<RepositoryInterface> { RepositoryInterfaceImpl(apiServiceDataSource = get()) }
}