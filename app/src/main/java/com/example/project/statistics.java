package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class statistics extends AppCompatActivity {
    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Typeface typeface = ResourcesCompat.getFont(this, R.font.chivo_bold);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        barChart = findViewById(R.id.bar_chart);
        BarDataSet barDataSet1 = new BarDataSet(dataValues1(),"INCOME");
        BarDataSet barDataSet2 = new BarDataSet(dataValues2(),"EXPENSE");
        barDataSet1.setColor(Color.GREEN);
        barDataSet1.setValueTextSize(12);
        barDataSet1.setValueTextColor(Color.GREEN);
        barDataSet1.setValueTypeface(typeface);
        barDataSet2.setColor(Color.RED);
        barDataSet2.setValueTextSize(12);
        barDataSet2.setValueTypeface(typeface);
        barDataSet2.setValueTextColor(Color.RED);

        BarData barData = new BarData(barDataSet1,barDataSet2);
        barChart.setData(barData);
        barChart.getDescription().setText("");
        barChart.animateY(2000);
        String[] days = new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMinimum(3);

        float barSpace = 0.1f;
        float groupSpace = 0.5f;

        barData.setBarWidth(0.2f);
        barChart.getXAxis().setAxisMinimum(0);

        barChart.groupBars(0, groupSpace, barSpace);

        barChart.invalidate();
    }
    private ArrayList<BarEntry> dataValues1(){
        ArrayList<BarEntry> dataVals = new ArrayList<>();
        dataVals.add(new BarEntry(1,0));
        dataVals.add(new BarEntry(2,100));
        dataVals.add(new BarEntry(3,80));
        dataVals.add(new BarEntry(4,20));
        dataVals.add(new BarEntry(5,0));
        dataVals.add(new BarEntry(6,0));
        dataVals.add(new BarEntry(7,20));
        return dataVals;
    }
    private ArrayList<BarEntry> dataValues2(){
        ArrayList<BarEntry> dataVals = new ArrayList<>();
        dataVals.add(new BarEntry(1,120));
        dataVals.add(new BarEntry(2,490));
        dataVals.add(new BarEntry(3,0));
        dataVals.add(new BarEntry(4,115));
        dataVals.add(new BarEntry(5,243));
        dataVals.add(new BarEntry(6,0));
        dataVals.add(new BarEntry(7,40));
        return dataVals;
    }
    public void back(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}