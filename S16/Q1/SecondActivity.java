package com.example.hellointent;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get the message passed from MainActivity
        String message = getIntent().getStringExtra("message");

        // Find the TextView in the layout
        TextView messageTextView = findViewById(R.id.messageTextView);

        // Set the received message into the TextView
        messageTextView.setText(message);
    }
}
