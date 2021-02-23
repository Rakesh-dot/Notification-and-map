package com.rakesh.googlemapsactivity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationActivity : AppCompatActivity() {
    private lateinit var btnNotification2: Button
    private lateinit var btnNotification1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        btnNotification1=findViewById(R.id.btnNotification1)
        btnNotification2=findViewById(R.id.btnNotification2)
        btnNotification1.setOnClickListener {
            showHighPriorityNotification()
        }
        btnNotification2.setOnClickListener {
            showLowPriorityNotification()
        }
    }

    private fun showLowPriorityNotification() {
        val notificationManager=NotificationManagerCompat.from(this)

        val notificationChannels=NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification=NotificationCompat.Builder(this,notificationChannels.Channel_2)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("Low priority notification")
                .setContentText("This is my notification body")
                .setColor(Color.BLUE)
                .build()

        notificationManager.notify(2,notification)
    }

    private fun showHighPriorityNotification() {
        val notificationManager=NotificationManagerCompat.from(this)

        val notificationChannels=NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification=NotificationCompat.Builder(this,notificationChannels.Channel_1)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("High priority notification")
                .setContentText("This is my notification body")
                .setColor(Color.BLUE)
                .build()

        notificationManager.notify(1,notification)
    }
}