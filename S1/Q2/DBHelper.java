package com.example.studentdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "Student.db";
    public static final String TABLE_NAME = "student";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(roll_no INTEGER PRIMARY KEY, name TEXT, address TEXT, percentage REAL)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertStudent(int roll_no, String name, String address, float percentage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("roll_no", roll_no);
        cv.put("name", name);
        cv.put("address", address);
        cv.put("percentage", percentage);

        long result = db.insert(TABLE_NAME, null, cv);
        return result != -1;
    }

    public String getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        StringBuilder result = new StringBuilder();

        while (cursor.moveToNext()) {
            result.append("Roll No: ").append(cursor.getInt(0)).append("\n");
            result.append("Name: ").append(cursor.getString(1)).append("\n");
            result.append("Address: ").append(cursor.getString(2)).append("\n");
            result.append("Percentage: ").append(cursor.getFloat(3)).append("%\n\n");
        }
        cursor.close();
        return result.toString();
    }
}
