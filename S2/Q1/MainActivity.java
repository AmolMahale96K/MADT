package com.example.perfectnumber;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText numberInput;
    Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.numberInput);
        checkButton = findViewById(R.id.checkButton);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = numberInput.getText().toString();

                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                int number = Integer.parseInt(input);
                int sum = 0;

                for (int i = 1; i < number; i++) {
                    if (number % i == 0) {
                        sum += i;
                    }
                }

                if (sum == number) {
                    Toast.makeText(MainActivity.this, number + " is a Perfect Number", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, number + " is NOT a Perfect Number", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

