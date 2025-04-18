package com.example.projectsqliteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "ProjectDB";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Project";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                "(id INTEGER PRIMARY KEY, name TEXT, dept TEXT, city TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertSampleData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME); // clear old
        insertProject(db, 1, "TCS", "IT", "Pune");
        insertProject(db, 2, "Infosys", "HR", "Mumbai");
        insertProject(db, 3, "Wipro", "Admin", "Bangalore");
        insertProject(db, 4, "HCL", "Finance", "Delhi");
        insertProject(db, 5, "Capgemini", "Tech", "Hyderabad");
    }

    private void insertProject(SQLiteDatabase db, int id, String name, String dept, String city) {
        ContentValues cv = new ContentValues();
        cv.put("id", id);
        cv.put("name", name);
        cv.put("dept", dept);
        cv.put("city", city);
        db.insert(TABLE_NAME, null, cv);
    }

    public Cursor getAllProjects() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
