package com.example.kopringdemo.domain.posts

import com.example.kopringdemo.domain.BaseTimeEntity
import javax.persistence.*

@Entity
class Posts (
    @Column(length = 500) // 문자열의 경우 VARCHAR(255)가 기본값, 이처럼 사이즈를 늘리고 싶거나 타입을 변경할 경우에 해당 어노테이션 사용
    var title: String = "",
    @Column(columnDefinition = "TEXT") // 타입을 변경하기 위해 해당 어노테이션 사용
    var content: String = "",
    val author: String = "",
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
        private set

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }
}