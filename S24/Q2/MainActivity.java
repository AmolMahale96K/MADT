
package com.example.carapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CarDatabaseOperations dbOperations;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbOperations = new CarDatabaseOperations(this);
        listView = findViewById(R.id.listView);

        // Inserting 5 car details
        insertCars();

        // Display all cars
        displayAllCars();
    }

    private void insertCars() {
        dbOperations.insertCar("Toyota", "SUV", "Red");
        dbOperations.insertCar("Honda", "Sedan", "Blue");
        dbOperations.insertCar("BMW", "Coupe", "Black");
        dbOperations.insertCar("Mercedes", "SUV", "White");
        dbOperations.insertCar("Audi", "Hatchback", "Silver");
    }

    private void displayAllCars() {
        // Query to get all car details
        Cursor cursor = dbOperations.getReadableDatabase().rawQuery("SELECT * FROM Car", null);

        // Define the columns to bind to the list view
        String[] from = {"name", "type", "color"};
        int[] to = {R.id.nameTextView, R.id.typeTextView, R.id.colorTextView};

        // Create the SimpleCursorAdapter
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.car_item, cursor, from, to, 0);
        
        // Set the adapter to the list view
        listView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        dbOperations.close();
        super.onDestroy();
    }
}
