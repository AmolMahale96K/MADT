
package com.example.textformatapp;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    TextView displayLabel;
    CheckBox boldCheckBox, italicCheckBox, underlineCheckBox;
    RadioButton redColorRadioButton, greenColorRadioButton, blueColorRadioButton;
    Button displayButton, clearButton, exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        displayLabel = findViewById(R.id.displayLabel);
        boldCheckBox = findViewById(R.id.boldCheckBox);
        italicCheckBox = findViewById(R.id.italicCheckBox);
        underlineCheckBox = findViewById(R.id.underlineCheckBox);
        redColorRadioButton = findViewById(R.id.redColorRadioButton);
        greenColorRadioButton = findViewById(R.id.greenColorRadioButton);
        blueColorRadioButton = findViewById(R.id.blueColorRadioButton);
        displayButton = findViewById(R.id.displayButton);
        clearButton = findViewById(R.id.clearButton);
        exitButton = findViewById(R.id.exitButton);

        // Display the message with the formatted text when the "Display" button is clicked
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String message = "Hello, " + name + "! Welcome to the app.";

                // Apply formatting based on user selection
                SpannableString spannableString = new SpannableString(message);
                
                // Apply Bold
                if (boldCheckBox.isChecked()) {
                    spannableString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, message.length(), 0);
                }
                // Apply Italic
                if (italicCheckBox.isChecked()) {
                    spannableString.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), 0, message.length(), 0);
                }
                // Apply Underline
                if (underlineCheckBox.isChecked()) {
                    spannableString.setSpan(new android.text.style.UnderlineSpan(), 0, message.length(), 0);
                }

                // Apply text color based on radio button selection
                if (redColorRadioButton.isChecked()) {
                    displayLabel.setTextColor(Color.RED);
                } else if (greenColorRadioButton.isChecked()) {
                    displayLabel.setTextColor(Color.GREEN);
                } else if (blueColorRadioButton.isChecked()) {
                    displayLabel.setTextColor(Color.BLUE);
                }

                // Set the text to the label
                displayLabel.setText(spannableString);
            }
        });

        // Clear the text fields and label when the "Clear" button is clicked
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameInput.setText("");
                displayLabel.setText("");
                boldCheckBox.setChecked(false);
                italicCheckBox.setChecked(false);
                underlineCheckBox.setChecked(false);
                redColorRadioButton.setChecked(false);
                greenColorRadioButton.setChecked(false);
                blueColorRadioButton.setChecked(false);
            }
        });

        // Exit the app when the "Exit" button is clicked
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
