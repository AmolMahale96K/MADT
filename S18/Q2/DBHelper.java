package com.example.projectdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "ProjectDB.db";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Project(id INTEGER PRIMARY KEY, name TEXT, dept TEXT, city TEXT)");

        // Insert 5 records
        db.execSQL("INSERT INTO Project VALUES (1, 'AI System', 'IT', 'Pune')");
        db.execSQL("INSERT INTO Project VALUES (2, 'Health App', 'CS', 'Mumbai')");
        db.execSQL("INSERT INTO Project VALUES (3, 'eCommerce', 'IT', 'Delhi')");
        db.execSQL("INSERT INTO Project VALUES (4, 'GameDev', 'CS', 'Nashik')");
        db.execSQL("INSERT INTO Project VALUES (5, 'ChatBot', 'AI', 'Hyderabad')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS Project");
        onCreate(db);
    }

    public Cursor getAllProjects() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM Project", null);
    }
}
