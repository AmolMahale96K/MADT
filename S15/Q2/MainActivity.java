
package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare views
    EditText firstNumberEditText, secondNumberEditText;
    Button addButton, subButton, divButton, mulButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        firstNumberEditText = findViewById(R.id.firstNumberEditText);
        secondNumberEditText = findViewById(R.id.secondNumberEditText);
        addButton = findViewById(R.id.addButton);
        subButton = findViewById(R.id.subButton);
        divButton = findViewById(R.id.divButton);
        mulButton = findViewById(R.id.mulButton);

        // Set the click listener for the Add button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("add");
            }
        });

        // Set the click listener for the Subtract button
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("subtract");
            }
        });

        // Set the click listener for the Divide button
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("divide");
            }
        });

        // Set the click listener for the Multiply button
        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("multiply");
            }
        });
    }

    // Method to perform the operation and show the result using Toast
    private void performOperation(String operation) {
        String num1String = firstNumberEditText.getText().toString();
        String num2String = secondNumberEditText.getText().toString();

        if (num1String.isEmpty() || num2String.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1String);
        double num2 = Double.parseDouble(num2String);
        double result = 0;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 == 0) {
                    Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                break;
        }

        // Display the result using Toast
        Toast.makeText(MainActivity.this, "Result: " + result, Toast.LENGTH_SHORT).show();
    }
}
