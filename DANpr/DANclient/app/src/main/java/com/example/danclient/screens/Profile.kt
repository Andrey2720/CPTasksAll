package com.example.danclient.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.navigation.NavHostController
import com.example.danclient.R
import org.json.JSONObject


//@Preview(showBackground = true)
@Composable
fun Profile(navController: NavHostController, data: String) {
    val j = JSONObject(data)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            text = "Мой профиль",
            style = TextStyle(Color(97, 0, 233)),
            fontSize = 20.sp
        )
        Image(modifier = Modifier
            .padding(top = 20.dp)
            .size(150.dp),
            painter = painterResource(id = R.drawable.logo_profile),
            contentDescription = "1")
        Column {
            Text(modifier = Modifier.padding(top = 40.dp),
                text = "Имя")
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
                Text(text = j.getString("name"),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 5.dp))
            }
            Text(modifier = Modifier.padding(top = 20.dp),
                text = "Метро")
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
                Text(text = GetCity(j),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 5.dp))
            }
            Text(modifier = Modifier.padding(top = 20.dp),
                text = "Email")
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
                Text(text = j.getString("email"),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 5.dp))
            }
            Text(modifier = Modifier.padding(top = 20.dp),
                text = "Номер телефона")
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
                Text(text = j.getString("phone"),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 5.dp))
            }
        }
        Button(
            onClick = {
//                    checkUser(context, loginText.value, passwordText.value, navController)
                      navController.navigate("Rules")
            },
            modifier = Modifier
                .padding(top = 35.dp)
                .size(width = 351.dp, height = 45.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(97, 0, 233))
        ) {
            Text(text = "Правила пользования")
        }



    }
}

private fun GetCity (j: JSONObject) : String{
    var s = ""
    try {
        s = j.getString("city")
    }catch (e: Exception){
        s = "Метро"
    }
    return s
}

