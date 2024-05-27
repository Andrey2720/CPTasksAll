package com.example.danclient

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
fun MainScreen() {
    val navController1 = rememberNavController()
    Column(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController1,
            startDestination = BottonItem.Screen1.route,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
        ) {
            composable(BottonItem.Screen1.route) { Category(navController1) }
            composable(BottonItem.Screen2.route) { Requests() }
            composable(BottonItem.Screen3.route) { Profile(navController1) }
            composable("Complect") { CompletionCard(navController1) }
            composable("ListMasters") { ListMasters(navController1) }
            composable("ShowMaster") { ShowItemMaster(navController1) }
            composable("Rules") { Rules() }
        }
        BottomNavigation(navController = navController1)
    }
}