package com.example.danclient.screens.user

import android.content.Context
import android.util.Log
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.danclient.R
import com.example.danclient.data.API
import com.example.danclient.data.CategoriesModel
import com.example.danclient.data.MasterModel
import org.json.JSONArray
import org.json.JSONObject

//@Preview(showBackground = true)
@Composable
fun ListMasters(data: String, context: Context,navController: NavHostController) {

    var masterList = remember {
        mutableStateOf(listOf<MasterModel>())
    }

    GetDataMaster(context, masterList, data)
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            text = "Предложения мастеров",
            style = TextStyle(Color(97, 0, 233)),
            fontSize = 20.sp
        )
        LazyColumn(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            itemsIndexed(masterList.value){
                    index, item ->  ItemMasters(navController, item, context, data)
            }
        }

    }
}


//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemMasters(navController: NavHostController, item: MasterModel, context: Context, data: String){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .height(180.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(97, 0, 233)
        ),
        shape = RoundedCornerShape(5.dp),
        onClick = {
            val j = JSONObject(data)
            j.put("masters_id", item.id)
            navController.navigate("ShowMaster/$j")
        }


    ) {
        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

            ) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween

            ){
                Column {
                    Text(text = item.name,
                        style = TextStyle(Color.White)
                    )
                    Text(modifier = Modifier.padding(top = 10.dp),
                        text = item.email,
                        style = TextStyle(Color.White)
                    )
                }
                Text(modifier = Modifier.padding(top = 10.dp),
                    text = item.city,
                    style = TextStyle(Color.White)
                )

            }
            Icon(modifier = Modifier.padding(end = 20.dp).size(100.dp).border(width = 2.dp, color = Color.Black),
                painter = painterResource(id = R.drawable.photo), contentDescription = "photo")
        }
    }
}


private fun GetDataMaster(context: Context, itemList: MutableState<List<MasterModel>>, data: String) {
    Log.d("MyLog", data)
    val j = JSONObject()

    j.put("city", JSONObject(data).getString("city"))
    j.put("category_id", JSONObject(data).getInt("category_id"))

    Log.d("MyLog", j.toString())

    val arr = JSONArray()
    arr.put(j)
    val url = "${API.DanIPI.api}/masterfilter"
    val queue = Volley.newRequestQueue(context)
    val request = JsonArrayRequest(
        Request.Method.POST,
        url,
        arr,
        {


            val list = ParsMaster(it)
            itemList.value = list
        },
        {
            Log.d("Error", "simpleRequest:${it}")
        }


    )
    queue.add(request)

}
private fun ParsMaster(res: JSONArray): ArrayList<MasterModel> {
    val list = ArrayList<MasterModel>()
    for (i in 0 until res.length()){
        val item = res[i] as JSONObject
        list.add(
            MasterModel(
                item.getInt("id"),
                item.getString("name"),
                item.getString("email"),
                item.getString("phone"),
                item.getInt("category_id"),
                item.getString("city"),
                item.getString("description"),
                item.getString("rating")
            )
        )
    }

    return list
}