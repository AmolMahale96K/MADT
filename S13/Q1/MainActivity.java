package com.example.lightbulbtoggleapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare views
    ImageView lightBulbImage;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        lightBulbImage = findViewById(R.id.lightBulbImage);
        toggleButton = findViewById(R.id.toggleButton);

        // Set initial state to OFF (light bulb image turned off)
        lightBulbImage.setImageResource(R.drawable.light_off);

        // Set toggle button listener
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Light is ON
                lightBulbImage.setImageResource(R.drawable.light_on);
            } else {
                // Light is OFF
                lightBulbImage.setImageResource(R.drawable.light_off);
            }
        });
    }
}
