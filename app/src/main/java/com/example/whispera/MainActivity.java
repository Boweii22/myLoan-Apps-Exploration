package com.example.whispera;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private TextView titleText, subTitleText;
    private Button getStartedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int color = getResources().getColor(R.color.main);  // Color from resources
            getWindow().setStatusBarColor(color);
        }

        layout = findViewById(R.id.layout);
        titleText = findViewById(R.id.titleText);
        subTitleText = findViewById(R.id.subTitleText);
        getStartedBtn = findViewById(R.id.getStartedBtn);

        // Initial animations when the activity opens
        animateElementsIn();

        // Set click listener for the button to animate elements out
        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateElementsOut();
                startActivity(new Intent(MainActivity.this, LoanActivity.class));
            }
        });


    }

    private void animateElementsIn() {
        // Animate the title text from the bottom
        ObjectAnimator titleAnimator = ObjectAnimator.ofFloat(titleText, "translationY", 1000f, 0f);
        titleAnimator.setDuration(1000); // 1 second for smooth floating
        titleAnimator.setStartDelay(200); // Delay for a better effect

        // Animate the subtitle text from the bottom
        ObjectAnimator subTitleAnimator = ObjectAnimator.ofFloat(subTitleText, "translationY", 1000f, 0f);
        subTitleAnimator.setDuration(1000);
        subTitleAnimator.setStartDelay(400);

        // Animate the button from the bottom
        ObjectAnimator buttonAnimator = ObjectAnimator.ofFloat(getStartedBtn, "translationY", 1000f, 0f);
        buttonAnimator.setDuration(1000);
        buttonAnimator.setStartDelay(600);

        // Start the animations together
        titleAnimator.start();
        subTitleAnimator.start();
        buttonAnimator.start();
    }

    private void animateElementsOut() {
        // Animate the title text back down
        ObjectAnimator titleAnimator = ObjectAnimator.ofFloat(titleText, "translationY", 0f, 1000f);
        titleAnimator.setDuration(1000);
        titleAnimator.setStartDelay(0);  // Start immediately

        // Animate the subtitle text back down
        ObjectAnimator subTitleAnimator = ObjectAnimator.ofFloat(subTitleText, "translationY", 0f, 1000f);
        subTitleAnimator.setDuration(1000);
        subTitleAnimator.setStartDelay(200); // Delay for staggered effect

        // Animate the button back down
        ObjectAnimator buttonAnimator = ObjectAnimator.ofFloat(getStartedBtn, "translationY", 0f, 1000f);
        buttonAnimator.setDuration(1000);
        buttonAnimator.setStartDelay(400); // Delay for staggered effect

        // Start the animations one by one with delays
        titleAnimator.start();
        subTitleAnimator.start();
        buttonAnimator.start();
    }
}
