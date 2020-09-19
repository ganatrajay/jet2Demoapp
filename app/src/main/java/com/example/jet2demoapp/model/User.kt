package com.example.jet2demoapp.model

data class User(var name:String, var avatar:String, val lastname:String?=null, val city:String?=null, val designation:String?=null, var about:String?=null)