 
package com.example.numbercheck;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText num1Edit, num2Edit;
    Button checkBtn;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        num1Edit = findViewById(R.id.num1Edit);
        num2Edit = findViewById(R.id.num2Edit);
        checkBtn = findViewById(R.id.checkBtn);
        resultText = findViewById(R.id.resultText);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1Str = num1Edit.getText().toString();
                String n2Str = num2Edit.getText().toString();

                if (n1Str.isEmpty() || n2Str.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                    return;
                }

                int num1 = Integer.parseInt(n1Str);
                int num2 = Integer.parseInt(n2Str);

                if (num1 > 20 && num2 > 20) {
                    Toast.makeText(MainActivity.this, "Both numbers are greater than 20. Enter again.", Toast.LENGTH_LONG).show();
                    resultText.setText("");
                } else {
                    resultText.setText("Number 1: " + num1 + "\nNumber 2: " + num2);
                }
            }
        });
    }
}
