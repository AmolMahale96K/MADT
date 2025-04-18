
package com.example.emailattachment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.provider.OpenableColumns;
import android.database.Cursor;

public class MainActivity extends AppCompatActivity {

    EditText emailTo, emailSubject, emailMessage;
    Button attachBtn, sendBtn;
    TextView attachStatus;
    Uri attachmentUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        emailTo = findViewById(R.id.emailTo);
        emailSubject = findViewById(R.id.emailSubject);
        emailMessage = findViewById(R.id.emailMessage);
        attachBtn = findViewById(R.id.attachBtn);
        sendBtn = findViewById(R.id.sendBtn);
        attachStatus = findViewById(R.id.attachStatus);

        attachBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAttachment();
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmailWithAttachment();
            }
        });
    }

    private void selectAttachment() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(Intent.createChooser(intent, "Select File"), 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK && data != null) {
            attachmentUri = data.getData();
            String fileName = getFileName(attachmentUri);
            attachStatus.setText("Attached: " + fileName);
        }
    }

    private String getFileName(Uri uri) {
        String result = "Unknown";
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                if (cursor != null) cursor.close();
            }
        }
        return result;
    }

    private void sendEmailWithAttachment() {
        String to = emailTo.getText().toString();
        String subject = emailSubject.getText().toString();
        String message = emailMessage.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.setType("*/*");
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        if (attachmentUri != null) {
            email.putExtra(Intent.EXTRA_STREAM, attachmentUri);
        }

        startActivity(Intent.createChooser(email, "Send Email..."));
    }
}
