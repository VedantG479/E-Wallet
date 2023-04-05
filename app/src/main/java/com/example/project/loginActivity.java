package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    private Button button;
    private EditText username, daily_spend, weekly_spend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        daily_spend = findViewById(R.id.daily_spend);
        weekly_spend = findViewById(R.id.weekly_spend);
        button = findViewById(R.id.submit_B1);

        SharedPreferences sharedPreferences = this.getSharedPreferences("demo", Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(username.getText().toString())){
                    username.setError("Enter Your Name ");
                    return;
                }
                else if (TextUtils.isEmpty(daily_spend.getText().toString())) {
                    daily_spend.setError("Please Enter Balance ");
                    return;
                }
                else if (TextUtils.isEmpty(weekly_spend.getText().toString())) {
                    weekly_spend.setError("PLease Enter Weekly Spending Goals ");
                }
                else {
                    Toast.makeText(loginActivity.this, "Submit Successfully", Toast.LENGTH_SHORT).show();
                }

                String name = username.getText().toString();
                String dailySpend = daily_spend.getText().toString();
                String weeklySpend = weekly_spend.getText().toString();
                sharedPreferences.edit().putString("userName",name).apply();
                sharedPreferences.edit().putString("tbalance",dailySpend).apply();
                sharedPreferences.edit().putString("weekly_spend",weeklySpend).apply();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
