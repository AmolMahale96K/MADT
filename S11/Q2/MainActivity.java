
package com.example.textformatapp;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameInput; // EditText to input name
    TextView resultLabel; // TextView to display result
    CheckBox boldCheckBox, italicCheckBox, underlineCheckBox; // Checkboxes for formatting
    RadioGroup colorRadioGroup; // RadioGroup for color selection
    Button displayButton, clearButton, exitButton; // Buttons for actions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        nameInput = findViewById(R.id.nameInput);
        resultLabel = findViewById(R.id.resultLabel);
        boldCheckBox = findViewById(R.id.boldCheckBox);
        italicCheckBox = findViewById(R.id.italicCheckBox);
        underlineCheckBox = findViewById(R.id.underlineCheckBox);
        colorRadioGroup = findViewById(R.id.colorRadioGroup);
        displayButton = findViewById(R.id.displayButton);
        clearButton = findViewById(R.id.clearButton);
        exitButton = findViewById(R.id.exitButton);

        // Set onClickListener for Display button
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                } else {
                    // Concatenate the message
                    String message = "Hello, " + name;

                    // Apply formatting based on checkbox selections
                    StringBuilder formattedMessage = new StringBuilder(message);
                    if (boldCheckBox.isChecked()) {
                        formattedMessage.insert(0, "<b>").append("</b>");
                    }
                    if (italicCheckBox.isChecked()) {
                        formattedMessage.insert(0, "<i>").append("</i>");
                    }
                    if (underlineCheckBox.isChecked()) {
                        formattedMessage.insert(0, "<u>").append("</u>");
                    }

                    // Set the color based on radio button selection
                    int selectedColorId = colorRadioGroup.getCheckedRadioButtonId();
                    RadioButton selectedColorRadioButton = findViewById(selectedColorId);
                    String color = "#000000"; // Default color: black
                    if (selectedColorRadioButton != null) {
                        switch (selectedColorRadioButton.getId()) {
                            case R.id.redRadioButton:
                                color = "#FF0000"; // Red color
                                break;
                            case R.id.greenRadioButton:
                                color = "#008000"; // Green color
                                break;
                            case R.id.blueRadioButton:
                                color = "#0000FF"; // Blue color
                                break;
                        }
                    }

                    // Apply the message formatting and color
                    resultLabel.setText(Html.fromHtml(formattedMessage.toString()));
                    resultLabel.setTextColor(Color.parseColor(color));
                }
            }
        });

        // Set onClickListener for Clear button
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the input and result label
                nameInput.setText("");
                resultLabel.setText("");
                boldCheckBox.setChecked(false);
                italicCheckBox.setChecked(false);
                underlineCheckBox.setChecked(false);
                colorRadioGroup.clearCheck();
            }
        });

        // Set onClickListener for Exit button
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Exit the application
                finish();
            }
        });
    }
}
