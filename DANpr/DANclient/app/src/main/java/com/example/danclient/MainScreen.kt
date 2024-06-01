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
import com.example.danclient.botton_navigation.BottonItem
import com.example.danclient.screens.Profile
import com.example.danclient.screens.Rules
import com.example.danclient.screens.user.Category
import com.example.danclient.screens.user.CompletionCard
import com.example.danclient.screens.user.ListMasters
import com.example.danclient.screens.user.Requests
import com.example.danclient.screens.user.ShowItemMaster


@Composable
fun MainScreen(data: String, context: Context) {
    val navController1 = rememberNavController()
    Column(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController1,
            startDestination = BottonItem.Screen1.route,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
        ) {
            composable(BottonItem.Screen1.route) { Category(navController1, data, context) }
            composable(BottonItem.Screen2.route) { Requests(data, context) }
            composable(BottonItem.Screen3.route) { Profile(navController1, data) }

            composable("Complect/{data}"
                , arguments = listOf(navArgument("data"){
                    type = NavType.StringType
                })) { CompletionCard(it.arguments?.getString("data") ?:"", context, navController1) }

            composable("ListMasters/{data}"
                , arguments = listOf(navArgument("data"){
                    type = NavType.StringType
                })) { ListMasters(it.arguments?.getString("data") ?:"", context, navController1) }

            composable("ShowMaster/{data}"
                , arguments = listOf(navArgument("data"){
                    type = NavType.StringType
                })) { ShowItemMaster(it.arguments?.getString("data") ?:"", context, navController1) }

            composable("Rules") { Rules() }
        }
        BottomNavigation(navController = navController1)
    }
}