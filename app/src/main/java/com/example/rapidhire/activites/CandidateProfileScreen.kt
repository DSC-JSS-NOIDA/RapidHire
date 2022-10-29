package com.example.rapidhire.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rapidhire.R
import com.example.rapidhire.databinding.ActivityCandidateProfileScreenBinding

class CandidateProfileScreen : AppCompatActivity() {
    lateinit var binding: ActivityCandidateProfileScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCandidateProfileScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profileBtn.setOnClickListener {
            val intent = Intent(this,CandidateDetailActivity::class.java)
            startActivity(intent)
        }

    }
}