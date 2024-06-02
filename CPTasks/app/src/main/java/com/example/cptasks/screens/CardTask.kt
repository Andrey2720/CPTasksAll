package com.example.cptasks.screens

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
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
import androidx.navigation.NavHostController
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.cptasks.data.API
import com.example.cptasks.data.FormaterDate
import com.example.cptasks.data.FormaterDateTime
import com.example.cptasks.data.FormaterTime
import org.json.JSONObject
import java.text.SimpleDateFormat


@Composable
fun CardTask(data: String, context: Context, navController: NavController) {

    val j = JSONObject(data)

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
                Text(text = j.getString("name"),
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
                Text(text = FormaterDate(j.getString("date_start")) ,
                    style = TextStyle(Color.White),
                    fontSize = 15.sp)
                Text(text = "${FormaterTime(j.getString("time_start")) } - ${FormaterTime(j.getString("time_end")) }",
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
                    Text(text = ParsStatus(j.getString("status")),
                        modifier = Modifier
                            .align(Alignment.CenterStart)
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
                    Text(text = FormaterDateTime(j.getString("creation_date")) ,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
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
                    Text(text = j.getString("description"),
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

            ButtonStat(navController = navController, j = j, context = context)
        }
        }

    }

@Composable
fun ButtonStat(navController: NavController, j: JSONObject, context: Context){
    val status = j.getInt("status")
    val id = j.getInt("id")
    when(status){
        0 -> {
            Button(onClick = {
                UpdateStatus(1, id, context)
                navController.navigateUp()
                             },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),

                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(63,120,31))) {
                Text(text = "Принять задачу", fontSize = 17.sp)
            }
        }
        1 ->{
            Button(onClick = {
                UpdateStatus(2, id, context)
                navController.navigateUp()
                             },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),

                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(63,120,31))) {
                Text(text = "Выполнено", fontSize = 17.sp)
            }
        }
        2 ->{
            Button(onClick = {

                navController.navigateUp()
                             },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),

                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(63,120,31))) {
                Text(text = "Вернуться к списку задач", fontSize = 17.sp)
            }
        }
    }
}

private fun ParsStatus(status: String): String{
    var stat = ""
    when(status){
        "0" -> {
            stat = "К исполнению"
        }
        "1" ->{
            stat = "В работе"
        }
        "2" ->{
            stat = "Выполнено"
        }
    }
    return stat
}

private fun UpdateStatus (status: Int, id: Int, context: Context){
    val j = JSONObject()

    j.put( "status", status)
    j.put( "id", id)
    Log.d("MyLog", j.toString())
    val url ="${API.AndAPI.api}/taskUpdateStatus"
    val queue = Volley.newRequestQueue(context)
    val request = JsonObjectRequest(
        Request.Method.POST,
        url,
        j,
        {

        },
        {
            Log.d("Error", "simpleRequest:${it}")
        }



    )
    queue.add(request)
}







