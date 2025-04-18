 
package com.example.palindromenumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText getnum; // EditText to enter number
    TextView resultLabel; // TextView to display result
    Button checkButton; // Button to trigger palindrome check

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        getnum = findViewById(R.id.getnum);
        resultLabel = findViewById(R.id.resultLabel);
        checkButton = findViewById(R.id.checkButton);

        // Set onClickListener for Check button
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the number from the EditText
                String numberStr = getnum.getText().toString();

                // Validate if the input is a number
                if (numberStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if the number is palindrome
                if (isPalindrome(numberStr)) {
                    resultLabel.setText("The number is a Palindrome");
                } else {
                    resultLabel.setText("The number is not a Palindrome");
                }
            }
        });
    }

    // Function to check if the number is a palindrome
    private boolean isPalindrome(String numStr) {
        String reversedStr = new StringBuilder(numStr).reverse().toString();
        return numStr.equals(reversedStr);
    }
}
