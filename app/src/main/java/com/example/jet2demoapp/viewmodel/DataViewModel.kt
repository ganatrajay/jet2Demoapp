package com.example.jet2demoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jet2demoapp.model.DataModel
import com.example.jet2demoapp.repo.DataRepository
import org.koin.standalone.KoinComponent

class DataViewModel(val dataRepository: DataRepository): ViewModel(), KoinComponent {

    var listData = MutableLiveData<List<DataModel>>()


    init {
        listData.value = listOf()
    }

    fun getData(){

        dataRepository.getData(object : DataRepository.OnData{
            override fun onSuccess(data: List<DataModel>){
                listData.value = data
            }
            override fun onFailure(){

            }
        })
    }
}