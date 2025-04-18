
package com.example.playernameapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText playerNameEditText;
    private Button showNameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the EditText and Button in the layout
        playerNameEditText = findViewById(R.id.playerNameEditText);
        showNameButton = findViewById(R.id.showNameButton);

        // Set an OnClickListener for the button
        showNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the name entered by the user
                String playerName = playerNameEditText.getText().toString();

                // Create an Intent to navigate to the SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // Put the player name into the Intent
                intent.putExtra("playerName", playerName);
                // Start the SecondActivity
                startActivity(intent);
            }
        });
    }
}
