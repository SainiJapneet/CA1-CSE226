package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.ui.theme.MyServiceDemo

class ServiceDemo : AppCompatActivity() {
    lateinit var btnStart: Button
    lateinit var btnStop: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_demo)
        btnStart = findViewById(R.id.btnStart)
        btnStop = findViewById(R.id.btnStop)

        btnStart.setOnClickListener {
            startService(Intent(this,MyServiceDemo::class.java))
        }
        btnStop.setOnClickListener {
            stopService(Intent(this,MyServiceDemo::class.java))
        }
    }
}