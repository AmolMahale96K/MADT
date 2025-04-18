
package com.example.factorialsum;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputNumber;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.inputNumber);
        resultText = findViewById(R.id.resultText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String input = inputNumber.getText().toString();

        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return false;
        }

        int number = Integer.parseInt(input);
        int id = item.getItemId();

        if (id == R.id.menu_factorial) {
            int fact = 1;
            for (int i = 1; i <= number; i++) {
                fact *= i;
            }
            resultText.setText("Factorial of " + number + " is: " + fact);
            return true;

        } else if (id == R.id.menu_sum_digits) {
            int sum = 0, n = number;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            resultText.setText("Sum of digits of " + number + " is: " + sum);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
