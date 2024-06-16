package com.example.danclient.screens.user

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.border
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.danclient.R
import com.example.danclient.botton_navigation.BottonItem
import com.example.danclient.data.API
import com.example.danclient.data.CategoriesModel
import com.example.danclient.data.MasterModel
import org.json.JSONArray
import org.json.JSONObject


//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowItemMaster(data: String, context: Context,navController: NavHostController) {
    val nameMaster = remember {
        mutableStateOf("")
    }
    val metro = remember {
        mutableStateOf("")
    }
    val descriptionMaster = remember {
        mutableStateOf("")
    }
    val rating = remember {
        mutableStateOf("")
    }


    GetOneMaster(context, data, nameMaster, metro, descriptionMaster, rating)
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            text = "Предложение",
            style = TextStyle(Color(97, 0, 233)),
            fontSize = 20.sp
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .padding(top = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(97, 0, 233)
            ),
            shape = RoundedCornerShape(5.dp),
            onClick = {}


        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(15.dp) ) {
                Text(modifier = Modifier.padding(top = 10.dp),
                    text = nameMaster.value,
                    style = TextStyle(Color.White)
                )
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                    ) {
                    Icon(modifier = Modifier
                        .padding(end = 20.dp)
                        .size(150.dp)
                        .border(width = 2.dp, color = Color.Black),
                        painter = painterResource(id = R.drawable.photo), contentDescription = "photo")
                }
                Text(modifier = Modifier.padding(top = 10.dp),
                    text = metro.value,
                    style = TextStyle(Color.White)
                )
                Text(modifier = Modifier.padding(top = 10.dp),
                    text = descriptionMaster.value,
                    style = TextStyle(Color.White)
                )
                Text(modifier = Modifier.padding(top = 30.dp),
                    text = "Рейтинг: ${rating.value}",
                    style = TextStyle(Color.White)
                )

            }
        }
        Button(
            onClick = {
                createForm(context, navController, data)
            },
            modifier = Modifier
                .padding(top = 25.dp)
                .size(width = 271.dp, height = 45.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(97, 0, 233))
        ) {
            Text(text = "Отправить заявку")
        }
    }
}

private fun GetOneMaster(context: Context, data: String, nameMaster: MutableState<String>, metro: MutableState<String>, descriptionMaster: MutableState<String>, rating: MutableState<String>){

    val masterID = JSONObject(data).getString("masters_id")
    val url ="${API.DanIPI.api}/master/$masterID"
    val queue = Volley.newRequestQueue(context)
    val req =  StringRequest(
        Request.Method.GET,
        url,
        {
            val obj = JSONObject(it)
            nameMaster.value = obj.getString("name")
            metro.value = obj.getString("city")
            descriptionMaster.value = obj.getString("description")
            rating.value = obj.getString("rating")

        },
        {
            Log.d("Error", "simpleRequest:${it}")
        }
    )

    queue.add(req)
}

private fun createForm(context: Context, navController: NavHostController, data: String){
    val j = JSONObject(data)

    j.put("files", "")
    j.put("status", 0)

    Log.d("MyLog", j.toString())
    val url ="${API.DanIPI.api}/form"
    val queue = Volley.newRequestQueue(context)
    val request = JsonObjectRequest(
        Request.Method.POST,
        url,
        j,
        {
            navController.navigate(BottonItem.Screen1.route)

        },
        {
            Log.d("Error", "simpleRequest:${it}")

        }

    )

    queue.add(request)
}