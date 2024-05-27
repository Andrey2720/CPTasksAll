package com.example.danclient.screens.master

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danclient.R
import com.example.danclient.botton_navigation.BottonItemMaster


//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RequestClient(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            text = "Запрос",
            style = TextStyle(Color(97, 0, 233)),
            fontSize = 20.sp
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .padding(top = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(97, 0, 233)
            ),
            shape = RoundedCornerShape(5.dp),
            onClick = {}


        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(15.dp) ) {
                Text(modifier = Modifier.padding(top = 10.dp),
                    text = "Ремонт",
                    style = TextStyle(Color.White)
                )
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                    ) {
                    Icon(modifier = Modifier.padding(end = 20.dp).size(150.dp).border(width = 2.dp, color = Color.Black),
                        painter = painterResource(id = R.drawable.photo), contentDescription = "photo")
                }
                Text(modifier = Modifier.padding(top = 10.dp),
                    text = "Метро",
                    style = TextStyle(Color.White)
                )
                Text(modifier = Modifier.padding(top = 10.dp),
                    text = "Описание сервиса",
                    style = TextStyle(Color.White)
                )

            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Button(
                onClick = {
//                    checkUser(context, loginText.value, passwordText.value, navController)
                          navController.navigate(BottonItemMaster.Screen1.route)
                },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .size(width = 147.dp, height = 45.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(97, 0, 233))
            ) {
                Text(text = "Принять")
            }
            Button(
                onClick = {
//                    checkUser(context, loginText.value, passwordText.value, navController)
                    navController.navigate(BottonItemMaster.Screen1.route)
                },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .size(width = 147.dp, height = 45.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(97, 0, 233))
            ) {
                Text(text = "Отклонить")
            }
        }
    }
}