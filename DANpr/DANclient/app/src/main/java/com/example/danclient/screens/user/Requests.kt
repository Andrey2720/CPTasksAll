package com.example.danclient.screens.user

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
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.danclient.R
import com.example.danclient.data.API
import com.example.danclient.data.CategoriesModel
import com.example.danclient.data.FormModel
import org.json.JSONArray
import org.json.JSONObject


@Composable
fun Requests(data: String, context: Context) {

    var itemList = remember {
        mutableStateOf(listOf<FormModel>())
    }

    GetForms(context, itemList, data)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            text = "Мои заявки",
            style = TextStyle(Color(97, 0, 233)),
            fontSize = 20.sp
        )
        LazyColumn(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            itemsIndexed(itemList.value){
                    index, item ->  ItemRequests(item)
            }
        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemRequests(item: FormModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .height(130.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(97, 0, 233)
        ),
        shape = RoundedCornerShape(5.dp),
        onClick = {}


    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween

            ) {
                Column {
                    Text(
                        text = item.name,
                        style = TextStyle(Color.White)
                    )
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = item.nameobj,
                        style = TextStyle(Color.White)
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = ParsStatus(item.status),
                    style = TextStyle(Color.White)
                )

            }
            Icon(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(100.dp)
                    .border(width = 2.dp, color = Color.Black),
                painter = painterResource(id = R.drawable.photo), contentDescription = "photo"
            )
        }
    }
}

private fun GetForms(context: Context, itemList: MutableState<List<FormModel>>, data: String){
    Log.d("MyLog", data)
    val userID = JSONObject(data).getString("id")
    val url ="${API.DanIPI.api}/formFilterFromUser/$userID"
    val queue = Volley.newRequestQueue(context)
    val req =  StringRequest(
        Request.Method.GET,
        url,
        {
            val obj = JSONArray(it)
            val list = ParsForms(obj)
            itemList.value = list

        },
        {
            Log.d("Error", "simpleRequest:${it}")
        }
    )

    queue.add(req)
}

private fun ParsForms(res: JSONArray): ArrayList<FormModel> {
    val list = ArrayList<FormModel>()
    for (i in 0 until res.length()){
        val item = res[i] as JSONObject
        list.add(
            FormModel(
                item.getString("name"),
                item.getString("nameobj"),
                item.getString("city"),
                item.getString("status")
            )
        )
    }

    return list
}

private fun ParsStatus(status: String): String{
    var stat = ""
    when(status){
        "0" -> {
            stat = "Отправлена"
        }
        "1" ->{
            stat = "Принята"
        }
        "2" ->{
            stat = "Отклонена"
        }

    }
    return stat
}

