
package com.example.employeeapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EmployeeDatabaseHelper dbHelper;
    private Button insertButton, showButton;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        insertButton = findViewById(R.id.insertButton);
        showButton = findViewById(R.id.showButton);
        listView = findViewById(R.id.listView);

        dbHelper = new EmployeeDatabaseHelper(this);

        // Insert records of 5 employees
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertEmployeeData();
            }
        });

        // Show all employees
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEmployeeData();
            }
        });
    }

    // Method to insert 5 employees
    private void insertEmployeeData() {
        dbHelper.insertEmployee("John Doe", "123 Main St", "1234567890");
        dbHelper.insertEmployee("Jane Smith", "456 Oak Ave", "9876543210");
        dbHelper.insertEmployee("Alice Brown", "789 Pine Rd", "5554443333");
        dbHelper.insertEmployee("Bob White", "321 Maple Dr", "6667778888");
        dbHelper.insertEmployee("Charlie Black", "654 Birch Ln", "9998887777");
    }

    // Method to show employee data
    private void showEmployeeData() {
        Cursor cursor = dbHelper.getAllEmployees();
        // Mapping columns to list view
        String[] from = {dbHelper.COL_EID, dbHelper.COL_NAME, dbHelper.COL_ADDRESS, dbHelper.COL_PHNO};
        int[] to = {R.id.eid, R.id.name, R.id.address, R.id.phno};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.list_item, cursor, from, to, 0);
        listView.setAdapter(adapter);
    }
}
