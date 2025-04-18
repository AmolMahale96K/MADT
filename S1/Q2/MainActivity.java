
package com.example.studentdb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText rollNoEdt, nameEdt, addressEdt, percentEdt;
    Button insertBtn, showBtn;
    TextView output;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollNoEdt = findViewById(R.id.rollno);
        nameEdt = findViewById(R.id.name);
        addressEdt = findViewById(R.id.address);
        percentEdt = findViewById(R.id.percentage);
        insertBtn = findViewById(R.id.insertBtn);
        showBtn = findViewById(R.id.showBtn);
        output = findViewById(R.id.output);

        dbHelper = new DBHelper(this);

        insertBtn.setOnClickListener(v -> {
            int roll = Integer.parseInt(rollNoEdt.getText().toString());
            String name = nameEdt.getText().toString();
            String addr = addressEdt.getText().toString();
            float perc = Float.parseFloat(percentEdt.getText().toString());

            boolean inserted = dbHelper.insertStudent(roll, name, addr, perc);
            if (inserted) {
                Toast.makeText(this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                rollNoEdt.setText("");
                nameEdt.setText("");
                addressEdt.setText("");
                percentEdt.setText("");
            } else {
                Toast.makeText(this, "Insertion Failed", Toast.LENGTH_SHORT).show();
            }
        });

        showBtn.setOnClickListener(v -> {
            String data = dbHelper.getAllStudents();
            output.setText(data.isEmpty() ? "No records found." : data);
        });
    }
}
