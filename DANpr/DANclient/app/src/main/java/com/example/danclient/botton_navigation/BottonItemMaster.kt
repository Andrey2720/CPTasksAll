package com.example.danclient.botton_navigation

import com.example.danclient.R

sealed class BottonItemMaster(val item:String, val iconId:Int, val route: String){

    object Screen1: BottonItemMaster("Screen1", R.drawable.mail, "screen 1")
    object Screen2: BottonItemMaster("Screen2", R.drawable.profile, "screen 2")
}
