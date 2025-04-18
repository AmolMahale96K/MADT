 
package com.example.progressbarapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button startButton;
    private int progressStatus = 0;
    private Handler handler = new Handler(); // To update UI from the background thread

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the ProgressBar and Button
        progressBar = findViewById(R.id.progressBar);
        startButton = findViewById(R.id.startButton);

        // Set the button's onClickListener
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProgress();
            }
        });
    }

    // Method to start the progress
    private void startProgress() {
        // Run the task on a separate thread to simulate a long task
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus++; // Increment progress by 1

                    // Update the progressBar status on the UI thread
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });

                    try {
                        Thread.sleep(100); // Simulate work by sleeping for 100ms
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Show a Toast when the progress is complete
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Task Complete!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start(); // Start the thread
    }
}
