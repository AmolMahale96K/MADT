
package com.example.spinnerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText itemInput;
    Spinner spinner;
    Button addButton, removeButton;
    ArrayAdapter<String> adapter;
    ArrayList<String> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemInput = findViewById(R.id.itemInput);
        spinner = findViewById(R.id.spinner);
        addButton = findViewById(R.id.addButton);
        removeButton = findViewById(R.id.removeButton);

        itemsList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsList);
        spinner.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = itemInput.getText().toString().trim();
                if (!newItem.isEmpty()) {
                    itemsList.add(newItem);
                    adapter.notifyDataSetChanged();
                    itemInput.setText("");
                    Toast.makeText(MainActivity.this, "Item added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Enter item name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemToRemove = itemInput.getText().toString().trim();
                if (itemsList.contains(itemToRemove)) {
                    itemsList.remove(itemToRemove);
                    adapter.notifyDataSetChanged();
                    itemInput.setText("");
                    Toast.makeText(MainActivity.this, "Item removed", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Item not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
