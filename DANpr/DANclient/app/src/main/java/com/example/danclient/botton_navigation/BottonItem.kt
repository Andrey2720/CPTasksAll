package com.example.danclient.botton_navigation

import com.example.danclient.R

sealed class BottonItem( val item:String, val iconId:Int, val route: String){
    object Screen1: BottonItem("Screen1", R.drawable.search, "screen 1")
    object Screen2: BottonItem("Screen2", R.drawable.mail, "screen 2")
    object Screen3: BottonItem("Screen3", R.drawable.profile, "screen 3")
}
