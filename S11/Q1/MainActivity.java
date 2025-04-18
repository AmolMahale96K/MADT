 
package com.example.poweraverageapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2; // EditText for entering two numbers
    Button powerButton, averageButton; // Buttons for calculating power and average

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        powerButton = findViewById(R.id.powerButton);
        averageButton = findViewById(R.id.averageButton);

        // Set onClickListener for Power button
        powerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    double number1 = Double.parseDouble(num1.getText().toString());
                    double number2 = Double.parseDouble(num2.getText().toString());

                    // Start ResultActivity and send numbers and calculation type
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("num1", number1);
                    intent.putExtra("num2", number2);
                    intent.putExtra("operation", "power");
                    startActivity(intent);
                }
            }
        });

        // Set onClickListener for Average button
        averageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    double number1 = Double.parseDouble(num1.getText().toString());
                    double number2 = Double.parseDouble(num2.getText().toString());

                    // Start ResultActivity and send numbers and calculation type
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("num1", number1);
                    intent.putExtra("num2", number2);
                    intent.putExtra("operation", "average");
                    startActivity(intent);
                }
            }
        });
    }

    // Method to validate input
    private boolean validateInput() {
        if (num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
