package com.example.rapidhire.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rapidhire.R
import com.example.rapidhire.databinding.ActivityUploadResumeBinding

class UploadResume : AppCompatActivity() {
    private lateinit var  binding: ActivityUploadResumeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadResumeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitBtn.setOnClickListener {
            val intent = Intent(this,CandidateDetailActivity::class.java)
            startActivity(intent)
        }

    }
}