package com.example.cptasks.screens.admin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun CreateUser() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            text = "Создание пользователя",
            style = TextStyle(Color(63, 120, 31)),
            fontSize = 20.sp
        )
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)){
            Column {
                Text(text = "Фамилия")
                OutlinedTextField(value = "", onValueChange = {},
                    modifier = Modifier
//                    .size(width = 250.dp, height = 58.dp)

                        .fillMaxWidth().padding(top = 5.dp),
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
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)){
            Column {
                Text(text = "Имя")
                OutlinedTextField(value = "", onValueChange = {},
                    modifier = Modifier
//                    .size(width = 250.dp, height = 58.dp)

                        .fillMaxWidth().padding(top = 5.dp),
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
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)){
            Column {
                Text(text = "Отчество")
                OutlinedTextField(value = "", onValueChange = {},
                    modifier = Modifier
//                    .size(width = 250.dp, height = 58.dp)

                        .fillMaxWidth().padding(top = 5.dp),
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
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)){
            Column {
                Text(text = "Email")
                OutlinedTextField(value = "", onValueChange = {},
                    modifier = Modifier
//                    .size(width = 250.dp, height = 58.dp)

                        .fillMaxWidth().padding(top = 5.dp),
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
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)){
            Column {
                Text(text = "Пароль")
                OutlinedTextField(value = "", onValueChange = {},
                    modifier = Modifier
//                    .size(width = 250.dp, height = 58.dp)

                        .fillMaxWidth().padding(top = 5.dp),
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

            Button(onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),

                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(63,120,31))) {
                Text(text = "Создать пользователя", fontSize = 17.sp)
            }
        }
    }

}