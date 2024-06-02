package com.example.cptasks.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.cptasks.R
import com.example.cptasks.data.API
import org.json.JSONObject


//@Preview (showBackground = true)
@Composable
fun Login(context: Context, navController:NavController) {
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
        Image(modifier = Modifier.padding(top = 35.dp),
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
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){
            Button(
                onClick = {
                    checkUser(context, loginText.value, passwordText.value, navController)
                          },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .size(width = 269.dp, height = 55.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(63,120,31))
            ) {
                Text(text = "Вход")
            }
        }


    }
}



private fun checkUser(context: Context, login: String, password: String, navController: NavController) {
    val j = JSONObject()

    j.put( "email", login)
    j.put( "password", password)
    Log.d("MyLog", j.toString())
    val url ="${API.AndAPI.api}/userLogin"
    val queue = Volley.newRequestQueue(context)
    val request = JsonObjectRequest(
        Request.Method.POST,
        url,
        j,
        {

            try {
                if(it.getString("role") == "0"){
                    val res = it.toString()
                    navController.navigate("listGroup/$res")
                }else{
                    val res = it.toString()
                    navController.navigate("userMain/$res")
                }


            } catch (e: Exception) {
                Toast.makeText(context, "Неверный логин или пароль!", Toast.LENGTH_SHORT).show()
            }
        },
        {
            Log.d("Error", "simpleRequest:${it}")
        }



    )

    queue.add(request)


}

