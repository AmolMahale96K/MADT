
package com.example.emailattachment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = findViewById(R.id.sendEmailBtn);

        sendBtn.setOnClickListener(v -> sendEmail());
    }

    private void sendEmail() {
        // Sample file from internal storage (change path as needed)
        File file = new File(getExternalFilesDir(null), "sample.txt");

        // You can write something to the file
        // or assume it's already saved there

        Uri uri = Uri.fromFile(file);

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("application/octet-stream");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"receiver@example.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject: Email with Attachment");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Please find the attachment below.");
        emailIntent.putExtra(Intent.EXTRA_STREAM, uri);

        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }
}
