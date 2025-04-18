package com.example.customerdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CustomerDB";
    private static final int DATABASE_VERSION = 1;

    // Table name
    public static final String TABLE_CUSTOMER = "Customer";

    // Columns in the Customer table
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_PH_NO = "ph_no";

    // Create table SQL query
    private static final String CREATE_TABLE_CUSTOMER = "CREATE TABLE " + TABLE_CUSTOMER + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_ADDRESS + " TEXT, " +
            COLUMN_PH_NO + " TEXT);";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CUSTOMER); // Create the Customer table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
        onCreate(db);
    }

    // Insert a new customer record into the table
    public void insertCustomer(String name, String address, String ph_no) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_PH_NO, ph_no);
        db.insert(TABLE_CUSTOMER, null, values); // Insert the data into the table
        db.close();
    }

    // Retrieve all customer details
    public Cursor getAllCustomers() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_CUSTOMER, null); // Select all data from the Customer table
    }
}
