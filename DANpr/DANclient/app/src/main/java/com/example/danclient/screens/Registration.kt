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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.danclient.R
import com.example.danclient.data.API
import org.json.JSONObject

//navHostController: NavHostController
//context: Context, navController:NavController
//@Preview(showBackground = true)
@Composable
fun Registration(navController: NavHostController, context: Context) {

    var nameText = remember {
        mutableStateOf("")
    }
    var loginText = remember {
        mutableStateOf("")
    }
    var phoneText = remember {
        mutableStateOf("")
    }
    var passwordText = remember {
        mutableStateOf("")
    }
    var checkboxval = remember {
        mutableStateOf(false)
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
//                .fillMaxHeight(0.6f)
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom

        ) {

            OutlinedTextField(
                modifier = Modifier.padding(top = 30.dp),
                value = nameText.value,
                onValueChange = {nameText.value = it},

                label = {Text(text = "Имя")},
                singleLine = true

            )

            OutlinedTextField(
                modifier = Modifier.padding(top = 30.dp),
                value = loginText.value,
                onValueChange = {loginText.value = it},

                label = {Text(text = "Email")},
                singleLine = true
            )
            OutlinedTextField(
                modifier = Modifier.padding(top = 30.dp),
                value = phoneText.value,
                onValueChange = {phoneText.value = it},

                label = {Text(text = "Телефон")},
                singleLine = true
            )

            OutlinedTextField(
                modifier = Modifier.padding(top = 30.dp),
                value = passwordText.value,
                onValueChange = {passwordText.value = it},

                label = {Text(text = "Пароль")},
                singleLine = true

            )

            Row (modifier = Modifier.padding(top = 20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = checkboxval.value, onCheckedChange = {checkboxval.value = it},
                    colors  = CheckboxDefaults.colors(checkedColor = Color(97, 0, 233)))
                Text(text = "Я Мастер")
            }

        }
        Row(
            modifier = Modifier.fillMaxSize().padding(bottom = 20.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Button(
                onClick = {
                    createUser(context, nameText.value, loginText.value, phoneText.value, passwordText.value, checkboxval.value, navController)
//                    navHostController.navigate("main")
                },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .size(width = 350.dp, height = 45.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(97, 0, 233))
            ) {
                Text(text = "Зарегистрироваться", fontSize = 18.sp)
            }

        }


    }
}



private fun createUser(context: Context, name: String,  login: String, phone: String, password: String, checkbox: Boolean, navController: NavController) {
    val j = JSONObject()
    j.put( "name", name)
    j.put( "email", login)
    j.put( "phone", phone)
    j.put( "password", password)
    Log.d("MyLog", j.toString())
    if (checkbox == false){
        val url ="${API.DanIPI.api}/user"
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
                } catch (e: Exception) {
                }
            },
            {
                Log.d("Error", "simpleRequest:${it}")
            }
        )

        queue.add(request)
    }else{
        try {
            navController.navigate("DescriptionMaster/${j}")
        } catch (e: Exception) {
            Log.d("Error", "simpleRequest:${e}")
        }
    }
}
