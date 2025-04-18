package com.example.poweraverageapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView resultText; // TextView to display result

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultText = findViewById(R.id.resultText);

        // Get data from Intent
        double num1 = getIntent().getDoubleExtra("num1", 0);
        double num2 = getIntent().getDoubleExtra("num2", 0);
        String operation = getIntent().getStringExtra("operation");

        // Perform operation and display result
        if (operation != null) {
            if (operation.equals("power")) {
                double powerResult = Math.pow(num1, num2);
                resultText.setText("Power: " + powerResult);
            } else if (operation.equals("average")) {
                double averageResult = (num1 + num2) / 2;
                resultText.setText("Average: " + averageResult);
            }
        }
    }
}
