package com.example.danclient.data

sealed class UserData (val name: String, val email:String, val phone:String){
    object User : UserData("","","")
}