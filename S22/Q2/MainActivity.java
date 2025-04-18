
package com.example.numericradio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText editNumber;
    RadioGroup radioGroup;
    RadioButton radioOddEven, radioPosNeg, radioSquare;
    Button btnClick;
    TextView textAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editNumber = findViewById(R.id.editNumber);
        radioGroup = findViewById(R.id.radioGroup);
        radioOddEven = findViewById(R.id.radioOddEven);
        radioPosNeg = findViewById(R.id.radioPosNeg);
        radioSquare = findViewById(R.id.radioSquare);
        btnClick = findViewById(R.id.btnClick);
        textAnswer = findViewById(R.id.textAnswer);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editNumber.getText().toString();

                if(input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                int num = Integer.parseInt(input);
                String result = "";

                if (radioOddEven.isChecked()) {
                    result = (num % 2 == 0) ? "No is Even" : "No is Odd";
                } else if (radioPosNeg.isChecked()) {
                    result = (num >= 0) ? "No is Positive" : "No is Negative";
                } else if (radioSquare.isChecked()) {
                    result = "Square is: " + (num * num);
                } else {
                    Toast.makeText(MainActivity.this, "Select an option", Toast.LENGTH_SHORT).show();
                    return;
                }

                textAnswer.setText("Ans : " + result);
            }
        });
    }
}
