package taotao.haoxiong.com.androidoreonotifydemo

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.app.TaskStackBuilder
import kotlinx.android.synthetic.main.activity_main.*
import android.app.NotificationChannel
import android.graphics.Color


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notify.setOnClickListener {
            showNotify()
        }
        notify1.setOnClickListener {
            showNotify1()
        }
    }

    private fun showNotify() {
        val builder = NotificationCompat.Builder(this, "yinjin")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("通知")
                .setContentText("通知内容")
                .setAutoCancel(true)
// Creates an explicit intent for an Activity in your app
        var intent = Intent(this, Main2Activity::class.java)
        val pendingIntent = TaskStackBuilder.create(this)
                .addParentStack(Main2Activity::class.java)
                .addNextIntent(intent)
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        builder.setContentIntent(pendingIntent)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val chan1 = NotificationChannel("yinjin","default", NotificationManager.IMPORTANCE_DEFAULT)
        chan1.lightColor = Color.GREEN
        chan1.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        notificationManager.createNotificationChannel(chan1)

       /* val chan2 = NotificationChannel("second","second", NotificationManager.IMPORTANCE_HIGH)
        chan2.lightColor = Color.BLUE
        chan2.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        notificationManager.createNotificationChannel(chan2)*/
        notificationManager.notify(1024,builder.build())
    }
    private fun showNotify1() {
        val builder = NotificationCompat.Builder(this, "yinjin1")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("通知1")
                .setContentText("通知内容1")
                .setAutoCancel(true)
// Creates an explicit intent for an Activity in your app
        var intent = Intent(this, Main2Activity::class.java)
        val pendingIntent = TaskStackBuilder.create(this)
                .addParentStack(Main2Activity::class.java)
                .addNextIntent(intent)
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        builder.setContentIntent(pendingIntent)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val chan1 = NotificationChannel("yinjin1","default1", NotificationManager.IMPORTANCE_DEFAULT)
        chan1.lightColor = Color.BLUE
        chan1.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        notificationManager.createNotificationChannel(chan1)

        /* val chan2 = NotificationChannel("second","second", NotificationManager.IMPORTANCE_HIGH)
         chan2.lightColor = Color.BLUE
         chan2.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
         notificationManager.createNotificationChannel(chan2)*/
        notificationManager.notify(101,builder.build())
    }
}
