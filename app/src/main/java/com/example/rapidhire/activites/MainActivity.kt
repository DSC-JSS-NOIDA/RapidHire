package com.example.rapidhire.activites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rapidhire.R
import com.example.rapidhire.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}