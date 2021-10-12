package com.koleszar.ktorclient.remote

import android.util.Log
import com.koleszar.ktorclient.remote.dto.PostRequest
import com.koleszar.ktorclient.remote.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val TAG = "PostsServiceImpl"

class PostsServiceImpl(
    private val client: HttpClient
) : PostsService {

    override suspend fun getPosts(): List<PostResponse> {
        return try {
            client.get { url(HttpRoutes.POSTS) }
        } catch (e: Exception) {
            Log.d(TAG, "Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        return try {
            client.post<PostResponse> {
                url(HttpRoutes.POSTS)
                contentType(ContentType.Application.Json)
                body = postRequest
            }
        } catch (e: Exception) {
            Log.d(TAG, "Error: ${e.message}")
            null
        }
    }
}