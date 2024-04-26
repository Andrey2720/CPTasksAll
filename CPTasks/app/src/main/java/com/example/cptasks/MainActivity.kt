package com.example.cptasks

import android.app.DownloadManager.Request
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Response
import com.android.volley.ResponseDelivery
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.util.Objects


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.tv)
        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener{
            getRes()
        }

        
    }
    private fun getRes(){
        val url ="http://192.168.1.149:3001/api/group"
        val queue = Volley.newRequestQueue(this)
        val request = StringRequest(com.android.volley.Request.Method.GET,
            url,
            {
                response->
                val obj = JSONArray(response).getJSONObject(2).getString("groupname")
//                val name = obj.getJSONObject("")

                Log.d("MyLog", "RESULT:$obj")
            },

            {
                Log.d("MyLog", "Volley ERR:$it")
            }
            )
        queue.add(request)

//
    }

}