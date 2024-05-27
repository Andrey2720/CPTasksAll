package com.example.danclient.screens.user

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController


//@Preview(showBackground = true)
@Composable
fun Category(navController: NavHostController) {

  Column(modifier = Modifier
      .fillMaxSize()
      .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
      Text(

          text = "Выберете категорию",
          style = TextStyle(Color(97, 0, 233)),
          fontSize = 20.sp
      )
      LazyColumn(
          modifier = Modifier.padding(top = 20.dp)
      ) {
          items(5){
              ListItem(navController)
          }
      }

  }
}



//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItem(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .height(65.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(97, 0, 233)
        ),
        shape = RoundedCornerShape(5.dp),
        onClick = {navController.navigate("Complect")}


        ) {
        Row(modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Text(text = "Бытовая техника",
                style = TextStyle(Color.White),
                fontSize = 20.sp
            )
        }
    }
}