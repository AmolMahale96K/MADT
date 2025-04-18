 
package com.example.alertdialogdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button showDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialogButton = findViewById(R.id.showDialogButton);

        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an AlertDialog.Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Set the title and message for the dialog box
                builder.setTitle("Alert Dialog")
                        .setMessage("Are you sure you want to exit?")
                        .setCancelable(false)

                        // Set positive button (OK)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Handle 'Yes' click event
                                finish(); // Close the app
                            }
                        })

                        // Set negative button (Cancel)
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Handle 'No' click event
                                dialog.cancel(); // Dismiss the dialog
                            }
                        });

                // Create and show the dialog box
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}
