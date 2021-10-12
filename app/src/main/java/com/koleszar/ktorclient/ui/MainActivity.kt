package com.koleszar.ktorclient.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.koleszar.ktorclient.R
import com.koleszar.ktorclient.remote.PostsService

class MainActivity : AppCompatActivity() {

    private val client = PostsService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}