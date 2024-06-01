package com.example.danclient.screens.master

import android.content.ClipDescription
import android.content.Context
import android.graphics.drawable.Icon
import android.util.Log
import android.util.Size
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.danclient.data.API
import com.example.danclient.data.CategoriesModel
import org.json.JSONArray
import org.json.JSONObject


//@Preview(showBackground = true)
@Composable
fun DescriptionMaster(data: String, navController: NavHostController, context: Context) {

    var itemList = remember {
        mutableStateOf(listOf<CategoriesModel>())
    }
    var expanded = remember {
        mutableStateOf(false)
    }
    var selectedItem = remember {
        mutableStateOf("")
    }
    var textFiledSize = remember {
        mutableStateOf(androidx.compose.ui.geometry.Size.Zero)
    }
    val icon = if (expanded.value){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }
    GetDataCategor(context, itemList)

    var selectedItemID = remember {
        mutableStateOf(0)
    }
    var cityText = remember {
        mutableStateOf("")
    }

    var descriptionText = remember {
        mutableStateOf("")
    }

    val dataReg = JSONObject(data)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            modifier = Modifier.fillMaxHeight(0.08f),
            text = "Укажите навыки",
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
                Text(text = "Категория техники",
                    style = TextStyle(Color.White)
                )
            }
        }
        OutlinedTextField(
            value = selectedItem.value,
            onValueChange = {selectedItem.value = it},
            modifier = Modifier

                .fillMaxWidth()
                .onGloballyPositioned { cord ->
                    textFiledSize.value = cord.size.toSize()
                }
                .padding(top = 10.dp, bottom = 10.dp),
            textStyle = TextStyle(fontSize=15.sp),

            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xffeeeeee),
                unfocusedTextColor = Color(0xff222222),
                focusedContainerColor = Color.White,
                focusedTextColor = Color(0xff222222)
            ),
            singleLine = true,
            trailingIcon = {
                Icon(icon, "", modifier = Modifier.clickable { expanded.value = !expanded.value })
            }
        )

        DropdownMenu(expanded = expanded.value, onDismissRequest = { expanded.value = false},
            modifier = Modifier.width(with(LocalDensity.current){textFiledSize.value.width.toDp()})
            ) {
            itemList.value.forEach {
                e ->
                DropdownMenuItem(text = { Text(text = e.name)}, onClick = {
                    selectedItem.value = e.name
                    selectedItemID.value = e.id
                })
            }
        }



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
            value = cityText.value,
            onValueChange = {cityText.value = it},
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
            value = descriptionText.value,
            onValueChange = {descriptionText.value = it},
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
                createMaster(context, navController, dataReg, cityText.value, descriptionText.value, selectedItemID.value)
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


private fun GetDataCategor(context: Context, itemList: MutableState<List<CategoriesModel>>){

    val url ="${API.DanIPI.api}/category"
    val queue = Volley.newRequestQueue(context)
    val req =  StringRequest(
        Request.Method.GET,
        url,
        {
            val obj = JSONArray(it)
            val list = ParsCategories(obj)
            itemList.value = list

        },
        {
            Log.d("Error", "simpleRequest:${it}")
        }
    )

    queue.add(req)
}

private fun createMaster(context: Context, navController: NavController, dataReg: JSONObject, city: String, description: String, categoriID:Int ){

    dataReg.put("category_id", categoriID)
    dataReg.put("city", city)
    dataReg.put("description", description)


    val url ="${API.DanIPI.api}/master"
    val queue = Volley.newRequestQueue(context)
    val request = JsonObjectRequest(
        Request.Method.POST,
        url,
        dataReg,
        {

            try {
                it.getString("name")
                val res = it.toString()
                navController.navigate("mainMaster/$it")
            } catch (e: Exception) {

            }
        },
        {
            Log.d("Error", "simpleRequest:${it}")
        }



    )

    queue.add(request)
}
private fun ParsCategories(res: JSONArray): ArrayList<CategoriesModel> {
    val list = ArrayList<CategoriesModel>()
    for (i in 0 until res.length()){
        val item = res[i] as JSONObject
        list.add(
            CategoriesModel(
                item.getInt("id"),
                item.getString("name"),
            )
        )
    }

    return list
}