package com.gbc.comp3074.COMP3074_Assignment1_10119783;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_FIRST = "com.gbc.comp3074.COMP3074_Assignment1_10119783.EXTRA_FIRST";
    public static final String EXTRA_SECOND = "com.gbc.comp3074.COMP3074_Assignment1_10119783.EXTRA_SECOND";
    public static final String EXTRA_THIRD = "com.gbc.comp3074.COMP3074_Assignment1_10119783.EXTRA_THIRD";
    public static final String EXTRA_FOURTH = "com.gbc.comp3074.COMP3074_Assignment1_10119783.EXTRA_FOURTH";
    public static final String EXTRA_FIFTH = "com.gbc.comp3074.COMP3074_Assignment1_10119783.EXTRA_FIFTH";
    public static final String EXTRA_SIXTH = "com.gbc.comp3074.COMP3074_Assignment1_10119783.EXTRA_SIXTH";

    public float pay;
    public float totalPay;
    public float otPay;
    public float tax;
    public float otHrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button about_button = findViewById(R.id.aboutbutton);
        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAbout();
            }
        });

        Button calculate_button = findViewById(R.id.calculatebtn);
        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCalculations();
            }
        });
    }

    private void startAbout() {

            Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(intent);
    }

    private void startCalculations() {
        EditText hoursWorked = (EditText)findViewById(R.id.hoursworked);
        EditText hourlyPay = (EditText)findViewById(R.id.hourlypay);

        float hrsWrkd = Float.parseFloat(hoursWorked.getText().toString());
        float hrlyPay = Float.parseFloat(hourlyPay.getText().toString());

        if(hrsWrkd <= 40) {
            pay = hrsWrkd * hrlyPay;
            otPay = 0;
            totalPay = pay;
            tax = (float) (pay * 0.18);
        }

        else {
            otHrs = hrsWrkd - 40;
            otPay = (float) (otHrs * (hrlyPay * 1.5));
            pay = (hrsWrkd - otHrs) * hrlyPay;
            totalPay = pay + otPay;
            tax = (float) (totalPay * 0.18);
        }

        Intent intent = new Intent(getApplicationContext(), CalculateActivity.class);
        intent.putExtra(EXTRA_FIRST, hrsWrkd);
        intent.putExtra(EXTRA_SECOND, hrlyPay);
        intent.putExtra(EXTRA_THIRD, pay);
        intent.putExtra(EXTRA_FOURTH, tax);
        intent.putExtra(EXTRA_FIFTH, otPay);
        intent.putExtra(EXTRA_SIXTH, totalPay);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_about: startAbout(); break;

            default: return super.onOptionsItemSelected(item);
        }

        return true;
    }
}