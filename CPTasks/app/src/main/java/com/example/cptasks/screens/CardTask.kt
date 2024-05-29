package com.example.cptasks.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Preview(showBackground = true)
//data: String, context: Context, navController: NavController
@Composable
fun CardTask() {
    var dateText = remember {
        mutableStateOf("")
    }
    var timeStartText = remember {
        mutableStateOf("")
    }
    var timeEndText = remember {
        mutableStateOf("")
    }
    var user = remember {
        mutableStateOf("")
    }
    var tema = remember {
        mutableStateOf("")
    }
    var description = remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.1f)
                .padding(top = 10.dp)
                .height(65.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(63,120,31)
            ),
            shape = RoundedCornerShape(5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                horizontalArrangement = Arrangement.Center

            ) {
                Text(text = "Тема",
                    style = TextStyle(Color.White),
                    fontSize = 20.sp
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "12-05-2024",
                    style = TextStyle(Color.White),
                    fontSize = 15.sp)
                Text(text = "09:00-10:00",
                    style = TextStyle(Color.White),
                    fontSize = 15.sp)
            }
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)){
            Column {
                Text(text = "Статус")
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
                    .background(Color(0xffeeeeee))
                    .height(40.dp)
                    .border(
                        BorderStroke(
                            width = 2.dp,
                            color = Color(145, 149, 160)
                        ),
                        shape = RoundedCornerShape(5.dp)
                    )
                ){
                    Text(text = "Назначен",
                        modifier = Modifier.align(Alignment.CenterStart)
                            .padding(start = 5.dp))
                }
            }

        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)){
            Column {
                Text(text = "Дата и время создания задачи")
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
                    .background(Color(0xffeeeeee))
                    .height(40.dp)
                    .border(
                        BorderStroke(
                            width = 2.dp,
                            color = Color(145, 149, 160)
                        ),
                        shape = RoundedCornerShape(5.dp)
                    )
                ){
                    Text(text = "02-04-2024  09:00",
                        modifier = Modifier.align(Alignment.CenterStart)
                            .padding(start = 5.dp))
                }
            }

        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)){
            Column {
                Text(text = "Описание")
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
                    .background(Color(0xffeeeeee))
                    .height(300.dp)
                    .border(
                        BorderStroke(
                            width = 2.dp,
                            color = Color(145, 149, 160)
                        ),
                        shape = RoundedCornerShape(5.dp)
                    )
                ){
                    Text(text = "Описание задчи",
                        modifier = Modifier
                            .padding(5.dp))
                }
            }

        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {

            Button(onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),

                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(63,120,31))) {
                Text(text = "Принять задачу", fontSize = 17.sp)
            }
        }
        }

    }




