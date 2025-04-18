 
package com.example.imagechanger;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button changeImageBtn;
    boolean isImage1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        imageView = findViewById(R.id.imageView);
        changeImageBtn = findViewById(R.id.changeImageBtn);

        changeImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isImage1) {
                    imageView.setImageResource(R.drawable.image2); // change to image2
                } else {
                    imageView.setImageResource(R.drawable.image1); // revert to image1
                }
                isImage1 = !isImage1;
            }
        });
    }
}
