
package com.example.textformattingapp;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare views
    EditText nameInput;
    Button displayButton, clearButton, exitButton;
    TextView displayLabel;
    RadioButton boldRadioButton, italicRadioButton, underlineRadioButton;
    CheckBox redColorCheckBox, greenColorCheckBox, blueColorCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        nameInput = findViewById(R.id.nameInput);
        displayButton = findViewById(R.id.displayButton);
        clearButton = findViewById(R.id.clearButton);
        exitButton = findViewById(R.id.exitButton);
        displayLabel = findViewById(R.id.displayLabel);
        boldRadioButton = findViewById(R.id.boldRadioButton);
        italicRadioButton = findViewById(R.id.italicRadioButton);
        underlineRadioButton = findViewById(R.id.underlineRadioButton);
        redColorCheckBox = findViewById(R.id.redColorCheckBox);
        greenColorCheckBox = findViewById(R.id.greenColorCheckBox);
        blueColorCheckBox = findViewById(R.id.blueColorCheckBox);

        // Set Display button action
        displayButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                return;
            }

            String message = "Hello, " + name;

            // Apply formatting based on user selections
            String style = "";

            if (boldRadioButton.isChecked()) {
                style += "font-weight: bold; ";
            }
            if (italicRadioButton.isChecked()) {
                style += "font-style: italic; ";
            }
            if (underlineRadioButton.isChecked()) {
                style += "text-decoration: underline; ";
            }

            String color = "#000000"; // Default black color
            if (redColorCheckBox.isChecked()) {
                color = "#FF0000"; // Red
            } else if (greenColorCheckBox.isChecked()) {
                color = "#008000"; // Green
            } else if (blueColorCheckBox.isChecked()) {
                color = "#0000FF"; // Blue
            }

            // Apply style and color to the message
            message = "<font style=\"" + style + "\" color=\"" + color + "\">" + message + "</font>";
            displayLabel.setText(Html.fromHtml(message));
        });

        // Set Clear button action
        clearButton.setOnClickListener(v -> {
            nameInput.setText("");
            displayLabel.setText("");
            boldRadioButton.setChecked(false);
            italicRadioButton.setChecked(false);
            underlineRadioButton.setChecked(false);
            redColorCheckBox.setChecked(false);
            greenColorCheckBox.setChecked(false);
            blueColorCheckBox.setChecked(false);
        });

        // Set Exit button action
        exitButton.setOnClickListener(v -> {
            finish();
        });
    }
}
