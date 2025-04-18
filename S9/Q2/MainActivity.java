
package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView resultText;
    Button btnAdd, btnSub, btnMul, btnDiv, btnClear, btnCalculate;

    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        resultText = findViewById(R.id.resultText);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnClear = findViewById(R.id.btnClear);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnAdd.setOnClickListener(v -> operator = "+");
        btnSub.setOnClickListener(v -> operator = "-");
        btnMul.setOnClickListener(v -> operator = "*");
        btnDiv.setOnClickListener(v -> operator = "/");

        btnCalculate.setOnClickListener(v -> {
            String s1 = num1.getText().toString();
            String s2 = num2.getText().toString();

            if (s1.isEmpty() || s2.isEmpty() || operator.equals("")) {
                Toast.makeText(MainActivity.this, "Please fill all fields and select operation", Toast.LENGTH_SHORT).show();
                return;
            }

            double a = Double.parseDouble(s1);
            double b = Double.parseDouble(s2);
            double res = 0;

            switch (operator) {
                case "+": res = a + b; break;
                case "-": res = a - b; break;
                case "*": res = a * b; break;
                case "/":
                    if (b == 0) {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    res = a / b;
                    break;
            }

            resultText.setText("Result: " + res);
        });

        btnClear.setOnClickListener(v -> {
            num1.setText("");
            num2.setText("");
            resultText.setText("0");
            operator = "";
        });
    }
}
