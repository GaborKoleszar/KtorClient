package com.koleszar.ktorclient.ui

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.koleszar.ktorclient.R
import com.koleszar.ktorclient.remote.PostsService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    @Inject
    lateinit var client: PostsService

    override fun onCreate(savedInstanceState: Bundle?) {

        GlobalScope.launch(Dispatchers.IO) {
            val posts = client.getPosts()
            withContext(Dispatchers.Main) {
                view?.findViewById<TextView>(R.id.textView)?.text = posts.toString()
            }
        }
        super.onCreate(savedInstanceState)
    }
}