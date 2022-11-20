package com.liteloapps.intentserviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceInfo = findViewById<TextView>(R.id.service_info)
        val startServiceBtn = findViewById<Button>(R.id.start_service_btn)
        val stopServiceBtn = findViewById<Button>(R.id.stop_service_btn)

        startServiceBtn.setOnClickListener {
            Intent(this, MyIntentService::class.java).also { service ->
                startService(service)
                serviceInfo.text = "Service running.."
            }
        }

        stopServiceBtn.setOnClickListener {
            MyIntentService.stopService()
            serviceInfo.text = "Service Stopped!"
        }
    }
}