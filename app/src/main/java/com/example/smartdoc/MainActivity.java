package com.example.smartdoc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button bt1;
    Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.Profile);
        bt2 = findViewById(R.id.ChatBot);
        bt1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivit.class);
            startActivity(intent);
        });
        bt2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ChatActivity.class);
            startActivity(intent);
        });


       /* public void ShowGif(View view) {
            ImageView imageView = findViewById(R.id.imageView);
            Glide.with(this).load(R.drawable.tenor).into(imageView);
        }
*/
    }
}