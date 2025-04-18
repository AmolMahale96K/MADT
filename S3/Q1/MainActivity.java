 
package com.example.armstrongchecker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText numberInput;
    Button checkButton;
    TextView resultLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.numberInput);
        checkButton = findViewById(R.id.checkButton);
        resultLabel = findViewById(R.id.resultLabel);

        checkButton.setOnClickListener(v -> {
            String input = numberInput.getText().toString();

            if (input.isEmpty()) {
                resultLabel.setText("Please enter a number");
                return;
            }

            int number = Integer.parseInt(input);
            if (isArmstrong(number)) {
                resultLabel.setText(number + " is an Armstrong number.");
            } else {
                resultLabel.setText(number + " is not an Armstrong number.");
            }
        });
    }

    private boolean isArmstrong(int num) {
        int sum = 0, temp = num, digit;
        while (temp != 0) {
            digit = temp % 10;
            sum += digit * digit * digit;
            temp /= 10;
        }
        return sum == num;
    }
}
