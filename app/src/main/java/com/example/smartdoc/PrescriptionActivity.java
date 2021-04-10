package com.example.smartdoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class  PrescriptionActivity extends AppCompatActivity {

    ImageButton prescription_accept;
    ImageButton prescription_cancel = findViewById(R.id.prescription_cancel);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);

        prescription_accept = findViewById(R.id.prescription_accept);
        prescription_accept.setOnClickListener(v -> {
            Intent intent = new Intent(this, PreferredTherapy.class);

            startActivity(intent);
        });

        prescription_cancel.setOnClickListener(this::onClick);

    }

/*           final Context context = this;
             imageButton = (ImageButton) findViewById(R.id.prescription_accept);
             imageButton.setOnClickListener(new View.OnClickListener()
             {
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(context,);
                 }
             });

*/


    private void onClick(View v) {
        Intent intent = new Intent(this, Expectedissue.class);
        startActivity(intent);
    }
}