
package com.example.projectapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ProjectDatabase projectDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        projectDatabase = new ProjectDatabase(this);

        // Insert some records
        projectDatabase.addMultipleProjects();

        // Get and display all records
        ArrayList<HashMap<String, String>> projectList = getAllProjects();
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                projectList,
                android.R.layout.simple_list_item_2,
                new String[] { "name", "dept" },
                new int[] { android.R.id.text1, android.R.id.text2 }
        );

        listView.setAdapter(adapter);
    }

    // Method to retrieve all project records
    private ArrayList<HashMap<String, String>> getAllProjects() {
        ArrayList<HashMap<String, String>> projectList = new ArrayList<>();
        SQLiteDatabase db = projectDatabase.dbHelper.getReadableDatabase();

        // Query to get all project records
        Cursor cursor = db.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                HashMap<String, String> project = new HashMap<>();
                project.put("name", cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME)));
                project.put("dept", cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DEPT)));
                project.put("city", cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CITY)));

                projectList.add(project);
            } while (cursor.moveToNext());
            cursor.close();
        }

        db.close();
        return projectList;
    }
}
    