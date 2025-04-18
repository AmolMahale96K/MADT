package com.example.carapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CarDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "car_database";
    private static final int DATABASE_VERSION = 1;

    // SQL query to create the Car table
    private static final String CREATE_TABLE_QUERY = 
        "CREATE TABLE Car (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, type TEXT, color TEXT);";

    public CarDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Car");
        onCreate(db);
    }
}
