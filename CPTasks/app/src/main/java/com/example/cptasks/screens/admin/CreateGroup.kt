package com.example.cptasks.screens.admin

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.cptasks.data.API
import org.json.JSONObject


@Composable
fun CreateGroup(context: Context, navController: NavController) {

    var nameText = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            text = "Создание группы",
            style = TextStyle(Color(63, 120, 31)),
            fontSize = 20.sp
        )
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)){
            Column {
                Text(text = "Название группы")
                OutlinedTextField(value = nameText.value, onValueChange = {nameText.value = it},
                    modifier = Modifier
//                    .size(width = 250.dp, height = 58.dp)

                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    textStyle = TextStyle(fontSize=15.sp),

                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xffeeeeee),
                        unfocusedTextColor = Color(0xff222222),
                        focusedContainerColor = Color.White,
                        focusedTextColor = Color(0xff222222)
                    ),
                    singleLine = true)
            }

        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {

            Button(onClick = { createGroup(context, nameText.value, navController) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),

                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(63,120,31))) {
                Text(text = "Создать группу", fontSize = 17.sp)
            }
        }
    }
}

private fun createGroup(context: Context, name: String, navController: NavController){

    val j = JSONObject()
    j.put("name", name)

    val url ="${API.AndAPI.api}/group"
    val queue = Volley.newRequestQueue(context)
    val request = JsonObjectRequest(
        Request.Method.POST,
        url,
        j,
        {
            try {
                it.getString("name")
                Toast.makeText(context, "Группа создна", Toast.LENGTH_SHORT).show()
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
}