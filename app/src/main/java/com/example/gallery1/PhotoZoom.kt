package com.example.gallery1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.gallery1.databinding.ActivityPhotoZoomBinding

class PhotoZoom : AppCompatActivity() {

    private lateinit var binding :ActivityPhotoZoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoZoomBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val imge = binding.imageZoom
        val oytim: String = intent.getSerializableExtra("t1") as String
        Glide.with(this).load(oytim).into(imge)
    }
}