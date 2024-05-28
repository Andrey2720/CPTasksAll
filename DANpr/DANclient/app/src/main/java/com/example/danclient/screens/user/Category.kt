package com.example.danclient.screens.user

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.danclient.data.CategoriesModel

import org.json.JSONArray
import org.json.JSONObject


//@Preview(showBackground = true)
@Composable
fun Category(navController: NavHostController) {

    var itemList = remember {
        mutableStateOf(listOf<CategoriesModel>())
    }

  Column(modifier = Modifier
      .fillMaxSize()
      .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
      Text(

          text = "Выберете категорию",
          style = TextStyle(Color(97, 0, 233)),
          fontSize = 20.sp
      )
      LazyColumn(
          modifier = Modifier.padding(top = 20.dp)
      ) {
          items(5){
              ListItem(navController)
          }
      }

  }
}



//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItem(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .height(65.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(97, 0, 233)
        ),
        shape = RoundedCornerShape(5.dp),
        onClick = {navController.navigate("Complect")}


        ) {
        Row(modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Text(text = "Бытовая техника",
                style = TextStyle(Color.White),
                fontSize = 20.sp
            )
        }
    }
}

private fun GetDataCategor(context: Context, itemList: MutableState<List<CategoriesModel>>){

    val url ="http://192.168.1.46:3002/api/category"
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


