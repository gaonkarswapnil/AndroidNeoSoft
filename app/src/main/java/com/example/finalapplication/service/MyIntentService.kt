package com.example.finalapplication.service

import android.app.IntentService
import android.content.Intent
import android.util.Log


class MyIntentService: IntentService("MyIntentService") {

    init {
        instance = this
    }

    companion object{
        private lateinit var instance: MyIntentService
        var isRunning = false

        fun onStopService(){
            Log.d("MyIntentService","Service is stopped")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(p0: Intent?) {

        try {
            isRunning = true
            while (isRunning){
                Log.d("MyIntentService","Service is Started")
                Thread.sleep(1000);
            }
        }catch (e:Exception){
            Thread.currentThread().interrupt()
        }

    }
}