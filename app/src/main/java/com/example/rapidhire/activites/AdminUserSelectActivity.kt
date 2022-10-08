package com.example.rapidhire.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.cardview.widget.CardView
import com.example.rapidhire.R

class AdminUserSelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_user_select)

        val btnAdmin = findViewById<CardView>(R.id.candidate)
        val btnUser = findViewById<CardView>(R.id.cardViewRec)

        btnAdmin.setOnClickListener {
            Handler().postDelayed(Runnable {
                val i = Intent(this, AuthActivity::class.java)
                startActivity(i)
            }, 3000)
        }

        btnUser.setOnClickListener {
            Handler().postDelayed(Runnable {
                val i = Intent(this, AuthActivity::class.java)
                startActivity(i)
            }, 3000)
        }
    }
}