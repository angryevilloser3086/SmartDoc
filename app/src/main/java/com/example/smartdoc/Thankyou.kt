package com.example.smartdoc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.activity_thankyou.*

class Thankyou : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thankyou)

        ThankYou.alpha = 0f

        val withEndAction = ThankYou.animate().setDuration(1500).alpha(1f).withEndAction {
            val t = Intent(this, MainActivity::class.java)
            startActivity(t)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }


        iv_inventos1.alpha = 0f
        iv_inventos1.animate().setDuration(1600).alpha(1f).withEndAction {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }

    }
}