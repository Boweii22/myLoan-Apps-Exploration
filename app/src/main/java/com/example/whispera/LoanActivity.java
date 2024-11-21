package com.example.whispera;

import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class LoanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int color = getResources().getColor(R.color.main);  // Color from resources
            getWindow().setStatusBarColor(color);
        }

    }
}