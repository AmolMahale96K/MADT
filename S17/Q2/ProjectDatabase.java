package com.example.projectapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ProjectDatabase {

    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public ProjectDatabase(Context context) {
        dbHelper = new DBHelper(context);
    }

    // Method to add project records
    public void addProject(String name, String dept, String city) {
        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NAME, name);
        values.put(DBHelper.COLUMN_DEPT, dept);
        values.put(DBHelper.COLUMN_CITY, city);

        db.insert(DBHelper.TABLE_NAME, null, values);
        db.close();
    }

    // Method to add multiple records
    public void addMultipleProjects() {
        addProject("Project A", "Engineering", "New York");
        addProject("Project B", "Marketing", "Los Angeles");
        addProject("Project C", "Finance", "Chicago");
        addProject("Project D", "HR", "San Francisco");
        addProject("Project E", "IT", "Boston");
    }
}
