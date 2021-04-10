package com.example.smartdoc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PreferredTherapy extends AppCompatActivity {

        ImageView imageView1;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferred_therapy);

        imageView1 = findViewById(R.id.ayurveda);
        imageView1.setOnClickListener(v ->{
            Intent intent = new Intent(this, Error.class);

            startActivity(intent);
        });
        imageView2 = findViewById(R.id.unani);
        imageView2.setOnClickListener(v ->{
            Intent intent = new Intent(this, Error.class);

            startActivity(intent);
        });
        imageView3 = findViewById(R.id.yoga);
        imageView3.setOnClickListener(v ->{
            Intent intent = new Intent(this, Error.class);

            startActivity(intent);
        });
        imageView4 = findViewById(R.id.englishmed);
        imageView4.setOnClickListener(v ->{
            Intent intent = new Intent(this, Error.class);

            startActivity(intent);
        });

    }
}