
package com.example.customerdatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    ListView listView;
    Button insertButton, showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the database helper and views
        dbHelper = new DatabaseHelper(this);
        listView = findViewById(R.id.listView);
        insertButton = findViewById(R.id.insertButton);
        showButton = findViewById(R.id.showButton);

        // Insert customer data when the Insert button is clicked
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inserting 5 customers
                dbHelper.insertCustomer("John Doe", "123 Main St", "1234567890");
                dbHelper.insertCustomer("Jane Smith", "456 Elm St", "9876543210");
                dbHelper.insertCustomer("Mark Johnson", "789 Oak St", "1122334455");
                dbHelper.insertCustomer("Emma Williams", "101 Pine St", "9988776655");
                dbHelper.insertCustomer("James Brown", "202 Maple St", "5566778899");

                Toast.makeText(MainActivity.this, "Customers Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        // Show all customer details when the Show button is clicked
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fetch all customers and display them in ListView
                Cursor cursor = dbHelper.getAllCustomers();
                if (cursor.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No Customers Found", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Array to store customer details
                String[] customerDetails = new String[cursor.getCount()];
                int i = 0;

                // Loop through the cursor and add customer details to the array
                while (cursor.moveToNext()) {
                    customerDetails[i] = "ID: " + cursor.getString(0) +
                            ", Name: " + cursor.getString(1) +
                            ", Address: " + cursor.getString(2) +
                            ", Phone: " + cursor.getString(3);
                    i++;
                }

                // Set up the ListView with the customer details
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, customerDetails);
                listView.setAdapter(adapter);
            }
        });
    }
}
