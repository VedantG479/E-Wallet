package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class recentTransactions extends AppCompatActivity {
    public ListView listView;
    public ArrayList<String> messages = new ArrayList<>();
    public ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_transactions);

        listView = findViewById(R.id.history);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,messages);
        listView.setAdapter(adapter);
        updatefuncALL(listView);
    }

    public void updatefuncALL(View view) {
        messages.clear();
        String bit ="";
        String sign ="";
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms"), null, null, null, null);

        while (cursor.moveToNext()) {
            String messageBody = cursor.getString(cursor.getColumnIndexOrThrow("body"));

            //Canara Bank
            if (messageBody.contains("amount") & messageBody.contains("Canara Bank")) {
                if ((messageBody.contains("CREDITED") || messageBody.contains("Credited") || messageBody.contains("credited") || messageBody.contains("credit"))){
                    sign = "+";
                    bit = "INCOME";
                    messages.add("↗  "+sign+messageBody.substring(17,messageBody.indexOf("h")) + bit);
                }
                else if ((messageBody.contains("DEBITED") || messageBody.contains("Debited") || messageBody.contains("debited") || messageBody.contains("debit"))){
                    sign = "-";
                    bit = "EXPENSE";
                    messages.add("↙  "+sign+messageBody.substring(17,messageBody.indexOf("h")) + bit);
                }
                /*else if (messageBody.contains("paid thru") & messageBody.contains("UPI")){
                    sign = "-";
                    bit = "EXPENSE";
                    messages.add(sign+messageBody.substring(2,messageBody.indexOf(".")) + bit);
                }*/
            }

            /*//SBI Bank
            if ((credit || debit) & messageBody.contains("SBI")){
                if (credit){
                    sign = "+";
                    bit = "INCOME";
                    messages.add()
                }
                else if (debit){
                    sign = "+";
                    bit = "EXPENSE";
                }
                messages.add(sign+messageBody.substring())
            }

            //PNB Bank
            if ((messageBody.contains("Credited") || messageBody.contains("credited") || messageBody.contains("Debited") || messageBody.contains("debited")) & messageBody.contains("PNB")){
                if (messageBody.contains("Credited") || messageBody.contains("credited")){
                    sign = "+";
                    bit = "INCOME";
                }
                else if (messageBody.contains("Debited") || messageBody.contains("debited")){
                    sign = "+";
                    bit = "EXPENSE";
                }
            }

            //Axis Bank
            if ((messageBody.contains("Credited") || messageBody.contains("credited") || messageBody.contains("credit") || messageBody.contains("Debited") || messageBody.contains("debited") || messageBody.contains("debit")) & messageBody.contains("PNB")){
                if (messageBody.contains("Credited") || messageBody.contains("credited")){
                    sign = "+";
                    bit = "INCOME";
                }
                else if (messageBody.contains("Debited") || messageBody.contains("debited")){
                    sign = "+";
                    bit = "EXPENSE";
                }
            }*/

        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }

    public void updatefuncINC(View view){
        messages.clear();
        String bit ="";
        String sign ="";
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms"), null, null, null, null);

        while (cursor.moveToNext()) {
            String messageBody = cursor.getString(cursor.getColumnIndexOrThrow("body"));

            //Canara Bank
            if (messageBody.contains("amount") & messageBody.contains("Canara Bank") & messageBody.contains("CREDITED")) {
                sign = "+";
                bit = "INCOME";
                messages.add("↗  "+sign+messageBody.substring(17,messageBody.indexOf("h")) + bit);
            }

            /*SBI Bank
            if ((messageBody.contains("Credited") || messageBody.contains("credited")) & messageBody.contains("SBI")){
                sign = "+";
                bit = "INCOME";
            }

            //PNB Bank
            if ((messageBody.contains("Credited") || messageBody.contains("credited")) & messageBody.contains("PNB")){
                sign = "+";
                bit = "INCOME";
            }

            //Axis Bank
            if ((messageBody.contains("Credited") || messageBody.contains("credited") || messageBody.contains("credit")) & messageBody.contains("PNB")){
                sign = "+";
                bit = "INCOME";
            }
            */
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }

    public void updatefuncEXP(View view){
        messages.clear();
        String bit ="";
        String sign ="";
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms"), null, null, null, null);

        while (cursor.moveToNext()) {
            String messageBody = cursor.getString(cursor.getColumnIndexOrThrow("body"));

            //Canara Bank
            if (messageBody.contains("amount") & messageBody.contains("Canara Bank") & messageBody.contains("DEBITED")) {
                sign = "-";
                bit = "EXPENSE";
                messages.add("↙  "+sign+messageBody.substring(17,messageBody.indexOf("h")) + bit);
            }

            /*SBI Bank
            if ((messageBody.contains("Debited") || messageBody.contains("debited")) & messageBody.contains("SBI")){
                sign = "-";
                bit = "EXPENSE";
            }

            //PNB Bank
            if ((messageBody.contains("Debited") || messageBody.contains("debited")) & messageBody.contains("PNB")){
                sign = "-";
                bit = "EXPENSE";
            }

            //Axis Bank
            if ((messageBody.contains("Debited") || messageBody.contains("debited") || messageBody.contains("debit")) & messageBody.contains("PNB")){
                sign = "-";
                bit = "EXPENSE";
            }
             */
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }

    public void back(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}