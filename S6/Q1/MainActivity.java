 
package com.example.loginform;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editEmail, editPassword;
    Button btnLogin;
    TextView signupText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        signupText = findViewById(R.id.signupText);

        btnLogin.setOnClickListener(v -> validateLogin());

        signupText.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Redirecting to Signup...", Toast.LENGTH_SHORT).show());
    }

    private void validateLogin() {
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            editEmail.setError("Email is required");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("Enter a valid email");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editPassword.setError("Password is required");
            return;
        }

        if (password.length() < 6) {
            editPassword.setError("Password must be at least 6 characters");
            return;
        }

        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
    }
}
