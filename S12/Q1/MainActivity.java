 
package com.example.lightbulbtoggle;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ToggleButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare the ImageView and ToggleButton
    ImageView lightBulbImageView;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        lightBulbImageView = findViewById(R.id.lightBulbImageView);
        toggleButton = findViewById(R.id.toggleButton);

        // Set the initial state of the light bulb to OFF (light_off.png)
        lightBulbImageView.setImageResource(R.drawable.light_off);

        // Set the listener for the toggle button
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // If the button is ON, display the light bulb ON (light_on.png)
                lightBulbImageView.setImageResource(R.drawable.light_on);
                Toast.makeText(MainActivity.this, "Light ON", Toast.LENGTH_SHORT).show();
            } else {
                // If the button is OFF, display the light bulb OFF (light_off.png)
                lightBulbImageView.setImageResource(R.drawable.light_off);
                Toast.makeText(MainActivity.this, "Light OFF", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
