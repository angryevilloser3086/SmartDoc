package com.example.smartdoc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_error.*


class Error : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        errornext.setOnClickListener {
            val errorIntent = Intent(this,Thankyou::class.java)
            startActivity(errorIntent)
        }
        Pharmacy.setOnClickListener {
            val mapIntent = Intent(this,MapActivity_ph::class.java)
            startActivity(mapIntent)
        }

    }
}
