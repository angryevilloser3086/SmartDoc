package com.example.smartdoc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Expectedissue extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expectedissue);

        Button button = findViewById(R.id.nextbutton);
        button.setOnClickListener(v -> new Intent(this, ProfileActivit.class));


        Button button1 = findViewById(R.id.backbutton);
        button1.setOnClickListener(v -> new Intent(this, PrescriptionActivity.class));
    }

}