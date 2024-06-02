package com.example.cptasks.data

sealed class API( val api:String){
    object AndAPI: API("http://192.168.1.46:3001/api")

}