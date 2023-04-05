/* package com.example.project;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class NotifyUser extends Application {
    public static final String ChannelID = "E-Wallet";
    @Override
    public void onCreate(){
        super.onCreate();
        Notification();
    }
    public void Notification(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(ChannelID, "Payment Made", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("HEY");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }

    }
}


 */