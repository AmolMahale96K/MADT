 
package com.example.armstrongnumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText getnum; // EditText to enter the number
    Button checkButton; // Button to trigger Armstrong number check

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        getnum = findViewById(R.id.getnum);
        checkButton = findViewById(R.id.checkButton);

        // Set onClickListener for Check button
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the number from the EditText
                String numberStr = getnum.getText().toString();

                // Validate if the input is empty
                if (numberStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert the number to an integer
                int number = Integer.parseInt(numberStr);

                // Check if the number is Armstrong
                if (isArmstrong(number)) {
                    Toast.makeText(MainActivity.this, "The number is an Armstrong number", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "The number is not an Armstrong number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Function to check if the number is Armstrong
    private boolean isArmstrong(int number) {
        int sum = 0;
        int temp = number;
        int digits = String.valueOf(number).length();

        // Calculate sum of the power of digits
        while (temp != 0) {
            int remainder = temp % 10;
            sum += Math.pow(remainder, digits);
            temp /= 10;
        }

        // If sum equals the original number, it's an Armstrong number
        return sum == number;
    }
}
