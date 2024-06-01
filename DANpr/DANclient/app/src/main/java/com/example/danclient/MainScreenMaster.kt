package com.example.danclient

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.danclient.botton_navigation.BottomNavigation
import com.example.danclient.botton_navigation.BottomNavigationMaster
import com.example.danclient.botton_navigation.BottonItem
import com.example.danclient.botton_navigation.BottonItemMaster
import com.example.danclient.screens.Profile
import com.example.danclient.screens.Rules
import com.example.danclient.screens.master.DescriptionMaster
import com.example.danclient.screens.master.RequestClient
import com.example.danclient.screens.master.RequestsMaster
import com.example.danclient.screens.user.Category
import com.example.danclient.screens.user.CompletionCard
import com.example.danclient.screens.user.ListMasters
import com.example.danclient.screens.user.Requests
import com.example.danclient.screens.user.ShowItemMaster


@Composable
fun MainScreenMaster(data: String, context: Context) {
    val navController2 = rememberNavController()
    Column(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController2,
            startDestination = BottonItemMaster.Screen1.route,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
        ) {

            composable(BottonItemMaster.Screen1.route) { RequestsMaster(navController2, data, context) }
            composable(BottonItemMaster.Screen2.route) { Profile(navController2, data) }
            composable("Rules") { Rules() }

            composable("RequestClient/{data}"
                , arguments = listOf(navArgument("data"){
                    type = NavType.StringType
                })) { RequestClient(it.arguments?.getString("data") ?:"",navController2, context) }

        }
        BottomNavigationMaster(navController = navController2)
    }
}