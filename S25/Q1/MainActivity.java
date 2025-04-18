package com.example.smsapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    private EditText phoneNumberEditText;
    private EditText messageEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText.getText().toString();
                String message = messageEditText.getText().toString();

                if (phoneNumber.isEmpty() || message.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both phone number and message.", Toast.LENGTH_SHORT).show();
                } else {
                    sendSMS(phoneNumber, message);
                }
            }
        });
    }

    private void sendSMS(String phoneNumber, String message) {
        // Check for SMS permission
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
            return;
        }

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(this, "SMS Sent", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to send SMS", Toast.LENGTH_SHORT).show();
        }
    }
}



// @Override
// public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//     super.onRequestPermissionsResult(requestCode, permissions, grantResults);

//     if (requestCode == 1) {
//         if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//             // Permission granted, proceed with sending SMS
//         } else {
//             Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
//         }
//     }
// }
