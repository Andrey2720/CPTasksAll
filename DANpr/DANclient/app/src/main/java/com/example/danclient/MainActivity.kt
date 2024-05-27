package com.example.danclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.danclient.botton_navigation.BottomNavigation
import com.example.danclient.botton_navigation.BottonItem
import com.example.danclient.screens.Login
import com.example.danclient.screens.Profile
import com.example.danclient.screens.Registration
import com.example.danclient.screens.master.DescriptionMaster
import com.example.danclient.screens.user.Category
import com.example.danclient.screens.user.Requests

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController=navController, startDestination = "login", modifier = Modifier.fillMaxSize()) {
                    composable("login") { Login(navController, this@MainActivity)}
//                navController
                    composable("reg") { Registration(navController, this@MainActivity)}
                    composable("DescriptionMaster") { DescriptionMaster() }
                    composable("main") { MainScreen()}
                    composable("mainMaster") { MainScreenMaster() }
                }

            }
            }
        }



