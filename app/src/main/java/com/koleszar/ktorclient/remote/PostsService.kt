package com.koleszar.ktorclient.remote

import com.koleszar.ktorclient.remote.dto.PostRequest
import com.koleszar.ktorclient.remote.dto.PostResponse

interface PostsService {

    suspend fun getPosts(): List<PostResponse>

    suspend fun createPost(postRequest: PostRequest): PostResponse?

}