package com.example.danclient.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.danclient.R
import com.example.danclient.data.API

import org.json.JSONObject


//context: Context, navController:NavController
//@Preview(showBackground = true)
@Composable
fun Login(navController: NavHostController, context: Context) {
    var loginText = remember {
        mutableStateOf("")
    }
    var passwordText = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
//            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//      Лого
        Image(modifier = Modifier.padding(top = 60.dp).size(180.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "1")
//      Поля для ввода
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom

        ) {
//          Логин
            OutlinedTextField(
                modifier = Modifier.padding(top = 30.dp),
                value = loginText.value,
                onValueChange = {loginText.value = it},

                label = {Text(text = "Логин")},
                singleLine = true

            )
//          Пароль
            OutlinedTextField(
                modifier = Modifier.padding(top = 30.dp),
                value = passwordText.value,
                onValueChange = {passwordText.value = it},

                label = {Text(text = "Пароль")},
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true
            )

        }
        Row(
            modifier = Modifier.fillMaxSize().padding(bottom = 20.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Button(
                onClick = {
                    checkUser(context, loginText.value, passwordText.value, navController)
//                          navController.navigate("main")
                },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .size(width = 147.dp, height = 45.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(97, 0, 233))
            ) {
                Text(text = "Вход")
            }
            Button(
                onClick = {
//                    checkUser(context, loginText.value, passwordText.value, navController)
                    navController.navigate("reg")
                },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .size(width = 147.dp, height = 45.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(97, 0, 233))
            ) {
                Text(text = "Регистрация")
            }
        }


    }
}



private fun checkUser(context: Context, login: String, password: String, navController: NavHostController) {
    val j = JSONObject()

    j.put( "email", login)
    j.put( "password", password)
    Log.d("MyLog", j.toString())
    val url ="${API.DanIPI.api}/userLogin"
    val queue = Volley.newRequestQueue(context)
    val request = JsonObjectRequest(
        Request.Method.POST,
        url,
        j,
        {

            try {
                it.getString("name")
                val res = it.toString()
                navController.navigate("main/$res")
//                navController.navigate("main")
            } catch (e: Exception) {

            }
        },
        {
            Log.d("Error", "simpleRequest:${it}")
        }



    )
    queue.add(request)

    val url1 ="${API.DanIPI.api}/masterLogin"
    val queue1 = Volley.newRequestQueue(context)
    val request1 = JsonObjectRequest(
        Request.Method.POST,
        url1,
        j,
        {

            try {
                it.getString("name")
                val res = it.toString()
//                navController.navigate("main/$res")

                navController.navigate("mainMaster/$it")
            } catch (e: Exception) {

            }
        },
        {
            Log.d("Error", "simpleRequest:${it}")
        }



    )
    queue1.add(request1)


}
