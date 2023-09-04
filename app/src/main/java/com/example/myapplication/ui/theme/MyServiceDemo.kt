package com.example.myapplication.ui.theme

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.myapplication.ServiceDemo

class MyServiceDemo: Service() {

    val ID = "Default_ID"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val notificationIntent = Intent(this,ServiceDemo::class.java)
        val pendingIntent= PendingIntent.getActivity(this, 0,notificationIntent, PendingIntent.FLAG_IMMUTABLE)
        val notification = NotificationCompat.Builder(this, ID)
            .setContentTitle("Foreground Service Notification")
            .setContentText("Default Notification")
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1, notification)

        return START_STICKY
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        stopForeground(true)
    }

    override fun stopService(name: Intent?): Boolean {
        return super.stopService(name)

    }
    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notChannel = NotificationChannel(ID,"Notification Channel", NotificationManager.IMPORTANCE_DEFAULT)
            val service= getSystemService(NotificationManager::class.java)
            service!!.createNotificationChannel(notChannel)
        }
        else{
            Toast.makeText(this,"SDK VERSION IS LOW",Toast.LENGTH_SHORT).show()
        }
    }
}