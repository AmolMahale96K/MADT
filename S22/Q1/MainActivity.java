 
package com.example.changeimage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button changeImageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        changeImageBtn = findViewById(R.id.changeImageBtn);

        // Set an initial image
        imageView.setImageResource(R.drawable.image1);

        changeImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change the image when the button is clicked
                imageView.setImageResource(R.drawable.image2);
            }
        });
    }
}
    