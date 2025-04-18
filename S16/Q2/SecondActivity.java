package com.example.playernameapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView playerNameTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Find the TextView and Button in the layout
        playerNameTextView = findViewById(R.id.playerNameTextView);
        backButton = findViewById(R.id.backButton);

        // Get the player name passed from MainActivity
        String playerName = getIntent().getStringExtra("playerName");

        // Display the player name in the TextView
        playerNameTextView.setText("Player Name: " + playerName);

        // Set an OnClickListener for the Back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to return to the MainActivity
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                // Start the MainActivity (this will finish SecondActivity and bring you back)
                startActivity(intent);
            }
        });
    }
}
