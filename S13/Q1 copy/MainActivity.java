package com.example.registrationform;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName, editAddress, editMobile, editAge;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editAddress = findViewById(R.id.editAddress);
        editMobile = findViewById(R.id.editMobile);
        editAge = findViewById(R.id.editAge);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> validateForm());
    }

    private void validateForm() {
        String name = editName.getText().toString();
        String address = editAddress.getText().toString();
        String mobile = editMobile.getText().toString();
        String age = editAge.getText().toString();

        if (TextUtils.isEmpty(name)) {
            editName.setError("Name is required");
            return;
        }

        if (TextUtils.isEmpty(address)) {
            editAddress.setError("Address is required");
            return;
        }

        if (TextUtils.isEmpty(mobile) || mobile.length() != 10) {
            editMobile.setError("Enter a valid 10-digit mobile number");
            return;
        }

        if (TextUtils.isEmpty(age) || Integer.parseInt(age) <= 0) {
            editAge.setError("Enter a valid age");
            return;
        }

        Toast.makeText(this, "Registration Successful!", Toast.LENGTH_LONG).show();
    }
}
