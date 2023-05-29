package com.intersonik.duygum

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import android.widget.RemoteViews.RemoteView
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.ktx.remoteMessage
import com.intersonik.duygum.ui.activity.MainActivity

const val channelId = "notification_channel"
const val channelName = "com.intersonik.duygum"

class MyFirebaseMessagingService : FirebaseMessagingService() {


    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        if(remoteMessage.getNotification() !=null ){
            generationNotification(remoteMessage.notification!!.title!!,remoteMessage.notification!!.body!!)
        }
    }
    @SuppressLint("RemoteViewLayout")
    fun getRemoteView (title: String, message: String) : RemoteViews {
     val remoteView = RemoteViews("com.intersonik.duygum",R.layout.notification)
    remoteView.setTextViewText(R.id.title,title)
    remoteView.setTextViewText(androidx.appcompat.R.id.message,message)
    remoteView.setImageViewResource(R.id.app_logo, R.drawable.app_icon)

        return remoteView
    }
    fun generationNotification(title: String, message: String) {

        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )

        var builder: NotificationCompat.Builder = NotificationCompat.Builder(
            applicationContext,
            channelId
        )
            .setSmallIcon(R.drawable.app_icon)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)

        builder = builder.setContent(getRemoteView(title, message))

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel(channelId, channelName,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)

        }

        notificationManager.notify(0,builder.build())

    }
}