package com.example.danclient.botton_navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState



@Composable
fun BottomNavigation(
    navController: NavController
) {
    val listItem = listOf(
        BottonItem.Screen1,
        BottonItem.Screen2,
        BottonItem.Screen3
    )
    NavigationBar(
//        modifier = Modifier.background(color = Color.White),
        containerColor = Color.White
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItem.forEach{item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route)},
                icon = { Icon(modifier = Modifier.size(30.dp),
                    painter = painterResource(id = item.iconId), contentDescription = "Ic")},
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(97, 0, 233),

                )

            )
        }
    }

}