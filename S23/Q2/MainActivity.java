
package com.example.nameformatter;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    Button displayBtn, clearBtn, exitBtn;
    TextView outputLabel;
    RadioButton redColor, blueColor, greenColor;
    CheckBox boldCheck, italicCheck, underlineCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        displayBtn = findViewById(R.id.displayBtn);
        clearBtn = findViewById(R.id.clearBtn);
        exitBtn = findViewById(R.id.exitBtn);
        outputLabel = findViewById(R.id.outputLabel);

        redColor = findViewById(R.id.redColor);
        blueColor = findViewById(R.id.blueColor);
        greenColor = findViewById(R.id.greenColor);

        boldCheck = findViewById(R.id.boldCheck);
        italicCheck = findViewById(R.id.italicCheck);
        underlineCheck = findViewById(R.id.underlineCheck);

        // Display button action
        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();

                // Constructing the formatted string based on checkboxes and radio buttons
                StringBuilder formattedText = new StringBuilder(name);

                if (boldCheck.isChecked()) {
                    formattedText.insert(0, "<b>").append("</b>");
                }
                if (italicCheck.isChecked()) {
                    formattedText.insert(0, "<i>").append("</i>");
                }
                if (underlineCheck.isChecked()) {
                    formattedText.insert(0, "<u>").append("</u>");
                }

                // Set the text color based on the selected radio button
                if (redColor.isChecked()) {
                    outputLabel.setTextColor(Color.RED);
                } else if (blueColor.isChecked()) {
                    outputLabel.setTextColor(Color.BLUE);
                } else if (greenColor.isChecked()) {
                    outputLabel.setTextColor(Color.GREEN);
                }

                // Apply HTML formatting
                outputLabel.setText(Html.fromHtml(formattedText.toString()));
            }
        });

        // Clear button action
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameInput.setText("");
                outputLabel.setText("");
                boldCheck.setChecked(false);
                italicCheck.setChecked(false);
                underlineCheck.setChecked(false);
                redColor.setChecked(false);
                blueColor.setChecked(false);
                greenColor.setChecked(false);
            }
        });

        // Exit button action
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Closes the app
            }
        });
    }
}
