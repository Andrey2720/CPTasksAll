package com.example.danclient.data



sealed class API( val api:String){
    object DanIPI: API("http://192.168.1.46:3002/api")

}