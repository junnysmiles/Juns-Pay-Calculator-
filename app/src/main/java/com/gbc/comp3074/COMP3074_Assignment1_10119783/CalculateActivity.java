package com.gbc.comp3074.COMP3074_Assignment1_10119783;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        Intent intent = getIntent();
        float hrsWrkd = intent.getFloatExtra(MainActivity.EXTRA_FIRST, 0);
        float hrlyPay = intent.getFloatExtra(MainActivity.EXTRA_SECOND, 0);
        float pay = intent.getFloatExtra(MainActivity.EXTRA_THIRD, 0);
        float tax = intent.getFloatExtra(MainActivity.EXTRA_FOURTH, 0);
        float otpay = intent.getFloatExtra(MainActivity.EXTRA_FIFTH, 0);
        float totalpay = intent.getFloatExtra(MainActivity.EXTRA_SIXTH, 0);

        TextView hrsWrkdInputted = (TextView)findViewById(R.id.hrsWrkedInput);
        TextView hrlyPayInputted = (TextView)findViewById(R.id.hrlyPayInput);

        hrsWrkdInputted.setText("" + hrsWrkd);
        hrlyPayInputted.setText("" + hrlyPay);

        TextView payCalc = (TextView)findViewById(R.id.pay);
        payCalc.setText("" + pay);

        TextView totalPay = (TextView)findViewById(R.id.totalPay);
        totalPay.setText("" +totalpay);

        TextView otPay = (TextView)findViewById(R.id.otPay);
        otPay.setText("" + otpay);

        TextView taxCalc = (TextView)findViewById(R.id.tax);
        taxCalc.setText("" + tax);

        Button back_button = findViewById(R.id.bckBtn);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });
    }

    private void goHome() {
        Intent home = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.second_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_home: goHome(); break;

            default: return super.onOptionsItemSelected(item);
        }

        return true;
    }
}