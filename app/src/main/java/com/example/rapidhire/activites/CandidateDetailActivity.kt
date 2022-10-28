package com.example.rapidhire.activites

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rapidhire.R
import com.example.rapidhire.databinding.ActivityCandidateDetailBinding
import com.example.rapidhire.utils.FileSearch
import java.io.File

class CandidateDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCandidateDetailBinding
    private val GALLERY_REQUEST_CODE=6
    private val CAMERA_REQUEST_CODE=6
    private var mSelectedImage = ""
    private lateinit var uri: Uri
    private lateinit var img_url: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCandidateDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextBtn.setOnClickListener {
            val intent = Intent(this,UploadResumeScreen::class.java)
            startActivity(intent)
        }
        binding.uploadPhotoTextView.setOnClickListener {
            openGalleryForImage()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == GALLERY_REQUEST_CODE) {
              binding.profileImage.setImageURI(data?.data)
            mSelectedImage = FileSearch.getRealPathFromURI(this, data?.data!!)

            uri = Uri.fromFile(File(mSelectedImage))

        } else if (resultCode == Activity.RESULT_OK && requestCode == CAMERA_REQUEST_CODE) {

            with(binding) {

                profileImage.setImageBitmap(data?.extras?.get("data") as Bitmap)
            }

            uri = Uri.fromFile(File(mSelectedImage))
            img_url=uri.toString()
        }
    }

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/+"
        startActivityForResult(intent,GALLERY_REQUEST_CODE)
    }
}