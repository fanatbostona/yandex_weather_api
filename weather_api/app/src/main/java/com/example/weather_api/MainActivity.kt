package com.example.weather_api

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var tv : TextView
    lateinit var tv1 : TextView
    lateinit var tv2 : TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tv = findViewById(R.id.textView)
        tv1 = findViewById(R.id.textView2)
        tv2 = findViewById(R.id.textView3)

        val apiInterface = wAPI.create().getWeatherList()

        apiInterface.enqueue(object : Callback<DataList> {
            override fun onResponse(call: Call<DataList>?, response: Response<DataList>?) {
                if(response?.body() != null) {
                    tv.text = response.body()?.fact?.temp.toString() + "°"
                    tv1.text = response.body()?.fact?.feels_like.toString() + "°"
                }
            }

            override fun onFailure(call: Call<DataList>?, t: Throwable?) {
                tv2.text =  t?.message.toString()
            }
        })
    }
}
