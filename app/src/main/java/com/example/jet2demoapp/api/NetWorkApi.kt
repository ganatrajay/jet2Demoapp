package com.example.jet2demoapp.api

import com.example.jet2demoapp.model.DataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetWorkApi{

    @GET("blogs")
    fun getData(@Query("page") page:Int=1, @Query("limit")limit:Int=10): Call<List<DataModel>>
}