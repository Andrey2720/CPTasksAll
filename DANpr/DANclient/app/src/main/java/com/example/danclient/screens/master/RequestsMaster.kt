package com.example.danclient.screens.master

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danclient.R

//@Preview(showBackground = true)
@Composable
fun RequestsMaster(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            text = "Поступившые запросы",
            style = TextStyle(Color(97, 0, 233)),
            fontSize = 20.sp
        )
        LazyColumn(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            items(5){
                ItemRequests(navController)
            }
        }

    }
}


//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemRequests(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .height(130.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(97, 0, 233)
        ),
        shape = RoundedCornerShape(5.dp),
        onClick = {navController.navigate("RequestClient")}


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
                        text = "Ремонт",
                        style = TextStyle(Color.White)
                    )
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = "У меня вот такая проблема",
                        style = TextStyle(Color.White)
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = "Метро",
                    style = TextStyle(Color.White)
                )

            }
            Icon(
                modifier = Modifier.padding(end = 20.dp).size(100.dp)
                    .border(width = 2.dp, color = Color.Black),
                painter = painterResource(id = R.drawable.photo), contentDescription = "photo"
            )
        }
    }
}