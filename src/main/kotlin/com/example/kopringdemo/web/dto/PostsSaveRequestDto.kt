package com.example.kopringdemo.web.dto

import com.example.kopringdemo.domain.posts.Posts

/**
 * DB Layer를 담당하는 Entity 클래스는 가장 Core한 클래스이다.
 * Entity가 자주 변경되면 여러 클래스에 영향이 가지만, DTO 클래스는 자주 변경이 필요하다.
 * 그래서 View Layer, DB Layer의 역할 분리를 확실하게 하는 것이 좋다.
 * 꼭, Entity 클래스와 Controller에서 쓸 DTO는 분리해서 사용하자.
 */

// View Layer
data class PostsSaveRequestDto (
    val title: String,
    val content: String,
    val author: String,
) {
    // DB Layer
    fun toEntity() = Posts(
        title = title,
        content = content,
        author = author
    )
}


