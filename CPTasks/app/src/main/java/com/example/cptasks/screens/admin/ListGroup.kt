package com.example.cptasks.screens.admin

import android.content.Context
import android.util.Log
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cptasks.R
import com.example.cptasks.data.API
import com.example.cptasks.data.GroupModel
import com.example.cptasks.data.ItemTaskModel
import org.json.JSONArray
import org.json.JSONObject


@Composable
fun ListGroup(data: String, context: Context, navController: NavController) {

    var itemList = remember {
        mutableStateOf(listOf<GroupModel>())
    }

    GetGroups(context, itemList, data)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            text = "Группы",
            style = TextStyle(Color(63,120,31)),
            fontSize = 20.sp
        )
        LazyColumn(
            modifier = Modifier.padding(top = 20.dp)
                    .fillMaxWidth()
                .fillMaxHeight(0.85f)
        ) {
            itemsIndexed(itemList.value){
                    index, item ->
                ListItem(item, context, navController)
            }
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Button(onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),

                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(63,120,31))) {
                Text(text = "Создать группу", fontSize = 17.sp)
            }
        }



}
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItem(
    item: GroupModel, context: Context, navController: NavController
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
            .height(90.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(63,120,31)
        ),
        shape = RoundedCornerShape(5.dp),
        onClick = {
            val j = JSONObject()
            j.put("group_tb_id", item.id)
            j.put("name", item.name)
            navController.navigate("ShowGroup/$j")

        }
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
            ){
            Text(text = item.name,
                    style = TextStyle(Color.White),
                    fontSize = 20.sp
                )
            Column(modifier = Modifier.padding(end = 15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(modifier = Modifier.size(40.dp),
                    tint = Color.White,
                    painter = painterResource(id = R.drawable.person), contentDescription = "photo")

                Text(text = item.count.toString(),
                    style = TextStyle(Color.White),
                    fontSize = 20.sp
                )

            }
        }

    }
}

private fun GetGroups(context: Context, itemList: MutableState<List<GroupModel>>, data: String){

    val url ="${API.AndAPI.api}/group"
    val queue = Volley.newRequestQueue(context)
    val req =  StringRequest(
        Request.Method.GET,
        url,
        {
            val obj = JSONArray(it)
            Log.d("MyLog", it)
            val list = ParsGroups(obj)
            itemList.value = list

        },
        {
            Log.d("Error", "simpleRequest:${it}")
        }
    )

    queue.add(req)
}

private fun ParsGroups(res: JSONArray): ArrayList<GroupModel> {
    val list = ArrayList<GroupModel>()
    for (i in 0 until res.length()){
        val item = res[i] as JSONObject
        list.add(
            GroupModel(
                item.getInt("id"),
                item.getString("name"),
                item.getInt("count"),

                )
        )
    }

    return list
}