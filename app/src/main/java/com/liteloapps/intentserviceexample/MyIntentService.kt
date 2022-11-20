package com.liteloapps.intentserviceexample

import android.app.IntentService
import android.content.Intent
import android.util.Log

const val TAG = "MyIntentService"

class MyIntentService : IntentService("IntentService") {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MyIntentService
        var isServiceRunning = false

        fun stopService() {
            Log.d(TAG, "Service stopped")
            isServiceRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        try {
            isServiceRunning = true
            while(isServiceRunning) {
                Log.d(TAG, "Service running...")
                Thread.sleep(2000)
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
            Log.d(TAG, e.message.toString())
        }

    }

}