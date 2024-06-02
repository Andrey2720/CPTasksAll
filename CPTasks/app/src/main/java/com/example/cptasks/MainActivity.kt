package com.example.cptasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cptasks.screens.CardTask
import com.example.cptasks.screens.CreateTask
import com.example.cptasks.screens.Login
import com.example.cptasks.screens.UserMainActivity
import com.example.cptasks.screens.admin.ListGroup
import com.example.cptasks.screens.admin.ShowGroup

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController,
                startDestination = "login") {
                composable("login"){
                    Login(this@MainActivity, navController)
                }
                composable("userMain/{data}",
                    arguments = listOf(navArgument("data"){
                        type = NavType.StringType
                    })
                ){

                    UserMainActivity(it.arguments?.getString("data") ?:"", this@MainActivity, navController)

                }
                composable("createTask/{data}",
                    arguments = listOf(navArgument("data"){
                        type = NavType.StringType
                    })){
                    CreateTask(it.arguments?.getString("data") ?:"", this@MainActivity, navController)
                }
                composable("cardTask/{data}",
                    arguments = listOf(navArgument("data"){
                        type = NavType.StringType
                    })){
//
                    CardTask(it.arguments?.getString("data") ?:"", this@MainActivity, navController)
                }

                composable("listGroup/{data}",
                    arguments = listOf(navArgument("data"){
                        type = NavType.StringType
                    })){
//
                    ListGroup(it.arguments?.getString("data") ?:"", this@MainActivity, navController)
                }

                composable("ShowGroup/{data}",
                    arguments = listOf(navArgument("data"){
                        type = NavType.StringType
                    })){
//
                    ShowGroup(it.arguments?.getString("data") ?:"", this@MainActivity, navController)
                }
            }
//            Login(this)
        }
    }
}

