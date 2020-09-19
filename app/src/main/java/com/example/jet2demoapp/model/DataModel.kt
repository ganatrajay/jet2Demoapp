package com.example.jet2demoapp.model

import java.io.Serializable

data class DataModel(val id:String?=null, val createdAt:String?=null, val content:String?=null, val comments:Int?=0, val likes:Int?=0 , val media:List<Media>?=null, val user:List<User>?=null):Serializable