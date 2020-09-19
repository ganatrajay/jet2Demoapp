package com.example.jet2demoapp.repo

import com.example.jet2demoapp.api.NetWorkApi
import com.example.jet2demoapp.model.DataModel
import retrofit2.Call
import retrofit2.Response

class DataRepository(val networkApi: NetWorkApi) {

    fun getData(onData: OnData){
        networkApi.getData().enqueue(object  : retrofit2.Callback<List<DataModel>>{
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>) {
                    onData.onSuccess((response.body() as List<DataModel>))
            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                onData.onFailure()
            }
        })
    }

    interface OnData{
        fun onSuccess(data: List<DataModel>)
        fun onFailure()
    }
}