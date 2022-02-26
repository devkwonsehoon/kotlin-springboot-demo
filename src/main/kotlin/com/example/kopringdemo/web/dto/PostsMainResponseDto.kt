package com.example.kopringdemo.web.dto

import com.example.kopringdemo.domain.posts.Posts
import java.time.LocalDateTime

data class PostsMainResponseDto (
    val id: Long,
    val title: String,
    val author: String,
    val updatedAt: LocalDateTime,
)

fun Posts.toPostsMainResponseDto() = PostsMainResponseDto (
    id = id,
    title = title,
    author = author,
    updatedAt = updatedAt
)