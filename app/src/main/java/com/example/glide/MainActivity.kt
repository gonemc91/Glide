package com.example.glide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.glide.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var imgURL: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {setContentView(it.root)}

        imgURL = savedInstanceState?.getString(KEY_IMAGE_URL) ?: imagesList[Random.nextInt(imagesList.size)]

        Glide.with(this)
            .load(imgURL)
            .placeholder(R.drawable.ic_bacground)
            .circleCrop()
            .into(binding.ImageView)

    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_IMAGE_URL, imgURL)
    }





    companion object{
        const val KEY_IMAGE_URL = "KEY_IMAGE_URL"
        val imagesList = listOf(
            "https://images.unsplash.com/photo-1680864216112-65b20b633db7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80",
            "https://images.unsplash.com/photo-1681120304349-f4fd8e080aa0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
            "https://images.unsplash.com/photo-1681140348643-cfe70c047792?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1112&q=80",
            "https://images.unsplash.com/photo-1680936613337-fc829882b375?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=817&q=80"
        )


    }
}