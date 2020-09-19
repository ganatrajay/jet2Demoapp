package com.example.jet2demoapp.api

import com.example.jet2demoapp.repo.DataRepository
import com.example.jet2demoapp.viewmodel.DataViewModel
import retrofit2.Retrofit
import org.koin.dsl.module.module
import org.koin.android.viewmodel.ext.koin.viewModel
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module{

    single { DataRepository(get())}

    single { createWebService() }

    viewModel { DataViewModel (get()) }

}

fun createWebService(): NetWorkApi{

    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("https://5e99a9b1bc561b0016af3540.mockapi.io/jet2/api/v1/")
        .build()

    return  retrofit.create(NetWorkApi::class.java)
}