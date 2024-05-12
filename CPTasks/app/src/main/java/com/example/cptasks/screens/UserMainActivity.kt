package com.example.cptasks.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.cptasks.data.ItemTaskModel
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Date

//@Preview(showBackground = true)
@Composable
fun UserMainActivity(data: String ,context: Context, navController: NavController) {
    var dateText = remember {
        mutableStateOf("")
    }
    var timeStartText = remember {
        mutableStateOf("")
    }
    var timeEndText = remember {
        mutableStateOf("")
    }
    var itemList = remember {
        mutableStateOf(listOf<ItemTaskModel>())
    }

    val formatter = SimpleDateFormat("yyyy-MM-dd")
    val date = Date()
    val current = formatter.format(date)
    dateText.value = current
    timeStartText.value = "00:00:00"
    timeEndText.value = "23:59:59"
    val userID = JSONObject(data).getInt("id")
    GetDataTasks(context, itemList, current, "23:59:59", "00:00:00", userID)


    Log.d("MyLog", "ДАТА:  $current")

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
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Дата:")
                    OutlinedTextField(
                        value = dateText.value,
                        onValueChange = {dateText.value = it},
                        modifier = Modifier

                            .size(width = 150.dp, height = 58.dp)
                            .padding(5.dp),
                        textStyle = TextStyle(fontSize=15.sp),

                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xffeeeeee),
                            unfocusedTextColor = Color(0xff222222),
                            focusedContainerColor = Color.White,
                            focusedTextColor = Color(0xff222222)
                        ),


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


                    )
                }

            }





        }
        Button(onClick = {
            val userID = JSONObject(data).getInt("id")
            GetDataTasks(context, itemList, dateText.value, timeEndText.value, timeStartText.value, userID)
                         },
            modifier = Modifier
                .width(250.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(63,120,31))
            ) {
            Text(text = "Применить",
                fontSize = 18.sp)
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
        ) {

            itemsIndexed(itemList.value){
                index, item ->  ListItem(item = item, context, navController)
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
            ) {
            Button(onClick = {
                val userID = JSONObject(data).getInt("id")
                navController.navigate("createTask/${userID}")
                             },
                modifier = Modifier
                    .width(180.dp),

                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(63,120,31))) {
                Text(text = "Создать задачу")
            }
        }
    }
}
//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItem(item: ItemTaskModel, context: Context, navController: NavController){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 7.dp)
            .height(65.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(63,120,31)
        ),
        shape = RoundedCornerShape(5.dp),
        onClick = {
            ShowCard(context, item.id, navController)
            Log.d("Error", "Тема: ${item}")
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                horizontalArrangement = Arrangement.Center

            ) {
                Text(text = item.name,
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
                Text(text = "${item.time_start} - ${item.time_end}",
                    style = TextStyle(Color.White),
                    fontSize = 15.sp)
                Text(text = "Статус: ${ParsStatus(item.status)}",
                    style = TextStyle(Color.White),
                    fontSize = 15.sp)
            }
        }
    }
}

//
//id: Int, context: Context, date: String, time_start: String,time_end: String
private fun GetDataTasks(context: Context, itemList: MutableState<List<ItemTaskModel>>, dateText: String, timeEndText: String, timeStartText: String, userID: Int){
    val j = JSONObject()
    j.put( "date_start", dateText)
    j.put( "time_start", timeStartText)
    j.put( "time_end", timeEndText)
    j.put( "user_tb_id", userID)

    val arr = JSONArray()
    arr.put(j)
    val url ="http://192.168.1.46:3001/api/taskFilter"
    val queue = Volley.newRequestQueue(context)
    val req =  JsonArrayRequest(
        Request.Method.POST,
        url,
        arr,
        {
            val list = ParsResp(it)
            itemList.value = list

        },
        {
            Log.d("Error", "simpleRequest:${it}")
        }
    )

    queue.add(req)
}

private fun ParsResp(res: JSONArray): ArrayList<ItemTaskModel> {
    val list = ArrayList<ItemTaskModel>()
    for (i in 0 until res.length()){
        val item = res[i] as JSONObject
        list.add(
            ItemTaskModel(
                item.getInt("id"),
                item.getString("name"),
                item.getString("description"),
                item.getString("status"),
                item.getString("creation_date"),
                item.getString("date_start"),
                item.getString("date_end"),
                item.getString("time_start"),
                item.getString("time_end"),
                item.getInt("user_tb_id")
            )
        )
    }

    return list
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

private fun ShowCard(context: Context, id:Int, navController: NavController){
    navController.navigate("cardTask/$id")
}