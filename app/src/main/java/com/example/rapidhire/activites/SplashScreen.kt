package com.example.rapidhire.activites

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.example.rapidhire.R

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this,R.color.white)
        setContentView(R.layout.activity_splash_screen)
        val lottieAnimationView = findViewById<LottieAnimationView>(R.id.lottie_anim)
        lottieAnimationView.playAnimation()
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, AdminUserSelectActivity::class.java))
        }, 1000)
    }
}