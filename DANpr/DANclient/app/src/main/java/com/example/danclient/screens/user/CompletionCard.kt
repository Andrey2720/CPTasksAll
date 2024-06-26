package com.example.danclient.screens.user

import android.content.Context
import android.util.Log
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.danclient.data.API
import org.json.JSONObject


//@Preview(showBackground = true)
@Composable
fun CompletionCard(data: String, context: Context, navController: NavHostController) {

    var nameobj = remember {
        mutableStateOf("")
    }
    var typeobj = remember {
        mutableStateOf("")
    }
    var city = remember {
        mutableStateOf("")
    }
    var description = remember {
        mutableStateOf("")
    }



    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            modifier = Modifier.fillMaxHeight(0.08f),
            text = "Уточните проблему",
            style = TextStyle(Color(97, 0, 233)),
            fontSize = 20.sp
        )


        Card(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp),

            colors = CardDefaults.cardColors(
            containerColor = Color(97, 0, 233)),
            shape = RoundedCornerShape(5.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Тип техники",
                    style = TextStyle(Color.White)
                )
            }
        }
        OutlinedTextField(
            value = nameobj.value,
            onValueChange = {nameobj.value = it},
            modifier = Modifier

                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            textStyle = TextStyle(fontSize=15.sp),

            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xffeeeeee),
                unfocusedTextColor = Color(0xff222222),
                focusedContainerColor = Color.White,
                focusedTextColor = Color(0xff222222)
            ),
            singleLine = true
        )


        Card(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
            .padding(),

            colors = CardDefaults.cardColors(
                containerColor = Color(97, 0, 233)),
            shape = RoundedCornerShape(5.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Тип проблемы",
                    style = TextStyle(Color.White)
                )
            }
        }
        OutlinedTextField(
            value = typeobj.value,
            onValueChange = {typeobj.value = it},
            modifier = Modifier

                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            textStyle = TextStyle(fontSize=15.sp),

            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xffeeeeee),
                unfocusedTextColor = Color(0xff222222),
                focusedContainerColor = Color.White,
                focusedTextColor = Color(0xff222222)
            ),
            singleLine = true
        )
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
            .padding(),

            colors = CardDefaults.cardColors(
                containerColor = Color(97, 0, 233)),
            shape = RoundedCornerShape(5.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Укажите станцию метро",
                    style = TextStyle(Color.White)
                )
            }
        }
        OutlinedTextField(
            value = city.value,
            onValueChange = {city.value = it},
            modifier = Modifier

                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            textStyle = TextStyle(fontSize=15.sp),

            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xffeeeeee),
                unfocusedTextColor = Color(0xff222222),
                focusedContainerColor = Color.White,
                focusedTextColor = Color(0xff222222)
            ),
            singleLine = true
        )
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
            .padding(),

            colors = CardDefaults.cardColors(
                containerColor = Color(97, 0, 233)),
            shape = RoundedCornerShape(5.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Описание своими словами",
                    style = TextStyle(Color.White)
                )
            }
        }
        OutlinedTextField(
            value = description.value,
            onValueChange = {description.value = it},
            modifier = Modifier

                .fillMaxWidth()
                .height(200.dp)
                .padding(top = 10.dp, bottom = 10.dp),
            textStyle = TextStyle(fontSize=15.sp),

            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xffeeeeee),
                unfocusedTextColor = Color(0xff222222),
                focusedContainerColor = Color.White,
                focusedTextColor = Color(0xff222222)
            ),

        )
        Button(
            onClick = {
                val j = JSONObject(data)
                j.put("nameobj", nameobj.value)
                j.put("typeobj", typeobj.value)
                j.put("description", description.value)
                j.put("city", city.value)

                navController.navigate("ListMasters/$j")
            },
            modifier = Modifier
                .padding(top = 15.dp)
                .size(width = 147.dp, height = 45.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(97, 0, 233))
        ) {
            Text(text = "Далее")
        }

    }

}


