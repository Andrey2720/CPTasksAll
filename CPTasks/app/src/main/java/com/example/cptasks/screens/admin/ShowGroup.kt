package com.example.cptasks.screens.admin

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cptasks.R


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ShowGroup() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            text = "Активные пользователи",
            style = TextStyle(Color(63, 120, 31)),
            fontSize = 20.sp
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp)
                .height(110.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(63,120,31)
            ),
            shape = RoundedCornerShape(5.dp),
            onClick = {
//            ShowCard(context, item.id, navController)
                Log.d("Error", "Тема: ")
            }
        ) {
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Группа разработки",
                    style = TextStyle(Color.White),
                    fontSize = 20.sp
                )
                Column(modifier = Modifier.padding(end = 15.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Icon(modifier = Modifier.size(40.dp),
                        tint = Color.White,
                        painter = painterResource(id = R.drawable.person), contentDescription = "photo")

                    Text(text = "3",
                        style = TextStyle(Color.White),
                        fontSize = 20.sp
                    )

                }
            }

        }
        Column(modifier = Modifier.padding(top = 15.dp).background(Color(222,225,230))) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.85f)
            ) {
                items(3){
                    ListIUsers()
                }
            }
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Button(onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),

                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(63,120,31))) {
                Text(text = "Добавить пользователя", fontSize = 17.sp)
            }
        }

    }
}




@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListIUsers(
//    item: ItemTaskModel, context: Context, navController: NavController
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .height(90.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(63,120,31)
        ),
        shape = RoundedCornerShape(5.dp),
        onClick = {
//            ShowCard(context, item.id, navController)
            Log.d("Error", "Тема: ")
        }
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Top) {
                Text(text = "Иванов Иван",
                style = TextStyle(Color.White),
                fontSize = 20.sp
            )
            }
            Column(modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom) {
                Text(text = "Разработчик",
                    style = TextStyle(Color.White),
                    fontSize = 20.sp
                )
            }

        }

    }
}

