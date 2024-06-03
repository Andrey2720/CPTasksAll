package com.example.cptasks.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cptasks.data.API
import org.json.JSONArray
import org.json.JSONObject

//@Preview(showBackground = true)
@Composable
fun CreateTask(data: String, context: Context, navController: NavController) {
    var dateText = remember {
        mutableStateOf("")
    }
    var timeStartText = remember {
        mutableStateOf("")
    }
    var timeEndText = remember {
        mutableStateOf("")
    }
    var checkboxval = remember {
        mutableStateOf(false)
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
    var idUser = remember {
        mutableStateOf(data.toInt())
    }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ) {
                    Text(text = "Дата:")
                    OutlinedTextField(
                        value = dateText.value,
                        onValueChange = {dateText.value = it},
                        modifier = Modifier

                            .size(width = 250.dp, height = 58.dp)
                            .padding(5.dp),
                        textStyle = TextStyle(fontSize=15.sp),

                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xffeeeeee),
                            unfocusedTextColor = Color(0xff222222),
                            focusedContainerColor = Color.White,
                            focusedTextColor = Color(0xff222222)
                        ),
                        singleLine = true
                        )
                }
                Row(
                    modifier = Modifier.padding(start = 24.dp, top = 5.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(text = "C:")
                    OutlinedTextField(
                        modifier = Modifier
                            .size(width = 150.dp, height = 58.dp)
                            .padding(5.dp),
                        value = timeStartText.value,
                        onValueChange = {timeStartText.value = it},
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xffeeeeee),
                            unfocusedTextColor = Color(0xff222222),
                            focusedContainerColor = Color.White,
                            focusedTextColor = Color(0xff222222)
                        ),
                        singleLine = true


                        )
                    Text(text = "По:")
                    OutlinedTextField(
                        modifier = Modifier
                            .size(width = 150.dp, height = 58.dp)
                            .padding(5.dp),
                        value = timeEndText.value,
                        onValueChange = {timeEndText.value = it},
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xffeeeeee),
                            focusedContainerColor = Color.White,
                        ),
                        singleLine = true
                        )
                }

            }

        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 15.dp),
            horizontalArrangement = Arrangement.Start) {
            Text(text = "Кому",
                fontSize = 20.sp)
        }
        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checkboxval.value, onCheckedChange = {checkboxval.value = it},
                colors  = CheckboxDefaults.colors(checkedColor = Color(63,120,31)))
            Text(text = "Себе")
        }
        Row {
            OutlinedTextField(value = user.value, onValueChange = {user.value = it},
                modifier = Modifier
//                    .size(width = 250.dp, height = 58.dp)

                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                textStyle = TextStyle(fontSize=15.sp),

                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffeeeeee),
                    unfocusedTextColor = Color(0xff222222),
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color(0xff222222)
                ),
                singleLine = true)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 15.dp),
            horizontalArrangement = Arrangement.Start) {
            Text(text = "Тема",
                fontSize = 20.sp)

        }
        Row {
            OutlinedTextField(value = tema.value, onValueChange = {tema.value = it},
                modifier = Modifier
//                    .size(width = 250.dp, height = 58.dp)

                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                textStyle = TextStyle(fontSize=15.sp),

                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffeeeeee),
                    unfocusedTextColor = Color(0xff222222),
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color(0xff222222)
                ),
                singleLine = true)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 15.dp),
            horizontalArrangement = Arrangement.Start) {
            Text(text = "Описание",
                fontSize = 20.sp)

        }
        Row {
            OutlinedTextField(value = description.value, onValueChange = {description.value = it},
                modifier = Modifier
//                    .size(width = 250.dp, height = 58.dp)

                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(start = 10.dp, end = 10.dp),
                textStyle = TextStyle(fontSize=15.sp),

                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffeeeeee),
                    unfocusedTextColor = Color(0xff222222),
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color(0xff222222)
                ))
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
            ) {
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),

                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(63,120,31))) {
                Text(text = "Посмотреть расписание", fontSize = 17.sp)
            }
            Button(onClick = { createTackDB(context, dateText.value, timeEndText.value, timeStartText.value, idUser, tema.value, description.value, navController, checkboxval.value, user.value) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),

                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(63,120,31))) {
                Text(text = "Создать задачу", fontSize = 17.sp)
            }
        }

    }
}



private fun createTackDB(context: Context, dateText: String, timeEndText: String, timeStartText: String,
                              userID: MutableState<Int>, tema: String, description: String, navController: NavController, checkboxval: Boolean, email: String){

    if (checkboxval == true){
        val j = JSONObject()

        j.put( "name", tema)
        j.put( "description", description)
        j.put( "files", "")
        j.put( "status", 0)
        j.put( "date_start", dateText)
        j.put( "date_end", dateText)
        j.put( "time_start", timeStartText)
        j.put( "time_end", timeEndText)
        j.put( "user_tb_id", userID.value)
        Log.d("MyLog", j.toString())
        val url ="${API.AndAPI.api}/task"
        val queue = Volley.newRequestQueue(context)
        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            j,
            {
                try {
                    it.getString("name")
                    Toast.makeText(context, "Задача создна", Toast.LENGTH_SHORT).show()
                    navController.navigateUp()

                } catch (e: Exception) {
                    Toast.makeText(context, "Что то пошло не так", Toast.LENGTH_SHORT).show()
                }

            },
            {
                Log.d("Error", "simpleRequest:${it}")
                Toast.makeText(context, "Что то пошло не так", Toast.LENGTH_SHORT).show()
            }

        )

        queue.add(request)
    }else{

        val jmail = JSONObject()
        jmail.put("email", email)

        val url ="${API.AndAPI.api}/userFromMail"
        val queue = Volley.newRequestQueue(context)
        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            jmail,
            {
                try {
                    Log.d("MyLog", "ID пользователя ${it.getInt("id")}")
                    val idUserE= it.getInt("id")
                    val j = JSONObject()

                    j.put( "name", tema)
                    j.put( "description", description)
                    j.put( "files", "")
                    j.put( "status", 0)
                    j.put( "date_start", dateText)
                    j.put( "date_end", dateText)
                    j.put( "time_start", timeStartText)
                    j.put( "time_end", timeEndText)
                    j.put( "user_tb_id", idUserE)
                    Log.d("MyLog", j.toString())
                    val url ="${API.AndAPI.api}/task"
                    val queue = Volley.newRequestQueue(context)
                    val request = JsonObjectRequest(
                        Request.Method.POST,
                        url,
                        j,
                        {
                            try {
                                it.getString("name")
                                Toast.makeText(context, "Задача создна", Toast.LENGTH_SHORT).show()
                                navController.navigateUp()

                            } catch (e: Exception) {
                                Toast.makeText(context, "Что то пошло не так", Toast.LENGTH_SHORT).show()
                            }

                        },
                        {
                            Log.d("Error", "simpleRequest:${it}")
                            Toast.makeText(context, "Что то пошло не так", Toast.LENGTH_SHORT).show()
                        }

                    )

                    queue.add(request)


                } catch (e: Exception) {
                    Toast.makeText(context, "Что то пошло не так", Toast.LENGTH_SHORT).show()
                }

            },
            {
                Log.d("Error", "simpleRequest:${it}")
                Toast.makeText(context, "Что то пошло не так", Toast.LENGTH_SHORT).show()
            }

        )

        queue.add(request)
    }}

