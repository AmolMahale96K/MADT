package com.example.employeeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeDatabaseHelper extends SQLiteOpenHelper {

    // Database name and version
    private static final String DATABASE_NAME = "EmployeeDB";
    private static final int DATABASE_VERSION = 1;

    // Table name and columns
    private static final String TABLE_NAME = "Employee";
    private static final String COL_EID = "E_id";
    private static final String COL_NAME = "name";
    private static final String COL_ADDRESS = "address";
    private static final String COL_PHNO = "ph_no";

    // SQL query to create table
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COL_EID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME + " TEXT, " +
            COL_ADDRESS + " TEXT, " +
            COL_PHNO + " TEXT)";

    // Constructor
    public EmployeeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when the database is created for the first time
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE); // Create the Employee table
    }

    // Called when the database version is updated
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method to insert employee data
    public void insertEmployee(String name, String address, String ph_no) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_ADDRESS, address);
        contentValues.put(COL_PHNO, ph_no);

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    // Method to get all employee details
    public Cursor getAllEmployees() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
