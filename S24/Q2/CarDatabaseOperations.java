package com.example.carapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CarDatabaseOperations {

    private SQLiteDatabase db;
    private CarDatabaseHelper dbHelper;

    public CarDatabaseOperations(Context context) {
        dbHelper = new CarDatabaseHelper(context);
    }

    // Method to insert car data
    public void insertCar(String name, String type, String color) {
        db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("type", type);
        contentValues.put("color", color);
        db.insert("Car", null, contentValues);
    }

    // Method to close database connection
    public void close() {
        dbHelper.close();
    }
}
