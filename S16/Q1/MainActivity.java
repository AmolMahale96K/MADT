 
package com.example.hellointent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the button in the layout
        Button sendButton = findViewById(R.id.sendButton);

        // Set an OnClickListener for the button
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // Put the message "Hello" into the Intent
                intent.putExtra("message", "Hello");
                // Start the SecondActivity
                startActivity(intent);
            }
        });
    }
}
