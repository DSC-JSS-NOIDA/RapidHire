package com.example.rapidhire.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.rapidhire.R
import com.example.rapidhire.databinding.ActivityAdminUserSelectBinding.inflate
import com.example.rapidhire.databinding.ActivityCandidateProfileScreenBinding

class CandidateProfileScreen : AppCompatActivity() {

    private lateinit var binding: ActivityCandidateProfileScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCandidateProfileScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}