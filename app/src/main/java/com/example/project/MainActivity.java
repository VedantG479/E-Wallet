package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.Manifest;

public class MainActivity extends AppCompatActivity {

    TextView username,Tbalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        SharedPreferences getShared = getSharedPreferences("demo", Context.MODE_PRIVATE);
        username = findViewById(R.id.show_username);
        Tbalance = findViewById(R.id.amount_show);
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms"), null, null, null, null);
        cursor.moveToFirst();
        while(cursor!=null){
            String sms = cursor.getString(12);
            if(sms.contains("amount") & sms.contains("Canara Bank")){
                Tbalance.setText("₹"+sms.substring(sms.lastIndexOf("R")+1,sms.indexOf("-")-2));
                break;
            }
            cursor.moveToNext();
        }
        username.setText(getShared.getString("userName",""));
    }
    public void recTran(View view){
        Intent intent = new Intent(getApplicationContext(),recentTransactions.class);
        startActivity(intent);
    }
    public void categories(View view){
        Intent intent = new Intent(getApplicationContext(),categoriseStats.class);
        startActivity(intent);
    }
}
/*
class SMSbg extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
    }
}

 */



