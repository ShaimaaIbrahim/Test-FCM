package com.google.fcmtesting.Service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.google.fcmtesting.MainActivity;
import com.google.fcmtesting.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Objects;

public class MyFirebaseMessageService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

 showNotification(remoteMessage.getNotification());
    }

    private void showNotification(RemoteMessage.Notification notification) {
        Intent intent=new Intent(this , MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivity(this ,0 , intent ,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setAutoCancel(false)
                .setContentIntent(pendingIntent);

        NotificationManager manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
    }

}
