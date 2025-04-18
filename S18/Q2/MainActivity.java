
package com.example.projectdb;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    DBHelper dbHelper;
    ArrayAdapter<String> adapter;
    ArrayList<String> projectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        dbHelper = new DBHelper(this);
        Cursor cursor = dbHelper.getAllProjects();

        projectList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                String record = "ID: " + cursor.getInt(0) +
                        "\nName: " + cursor.getString(1) +
                        "\nDept: " + cursor.getString(2) +
                        "\nCity: " + cursor.getString(3);
                projectList.add(record);
            } while (cursor.moveToNext());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, projectList);
        listView.setAdapter(adapter);
    }
}
