package com.example.smartdoc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Details_to_DoctorActivity extends AppCompatActivity {
    ImageButton bt1;
    ImageButton bt2;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_to_doctor);

        bt1=(ImageButton) findViewById(R.id.details_to_Doctor_cancel);
        bt2=(ImageButton) findViewById(R.id.details_to_Doctor_accept);
        bt1.setOnClickListener(new View.OnClickListener() {
           /* @Override
            public void onClick() {
                onClick();
            }
*/
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Details_to_DoctorActivity.this,PrescriptionActivity.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Details_to_DoctorActivity.this,Expectedissue.class);
                startActivity(intent);
            }
        });
    }
}
