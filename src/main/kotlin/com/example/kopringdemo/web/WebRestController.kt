package com.example.kopringdemo.web

import com.example.kopringdemo.domain.posts.PostsRepository
import com.example.kopringdemo.service.PostsService
import com.example.kopringdemo.web.dto.PostsSaveRequestDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WebRestController @Autowired constructor(
    private val postsRepository: PostsRepository,
    private val postsService: PostsService
) {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World!"
    }

    @PostMapping("/posts")
    fun savePost(@RequestBody dto: PostsSaveRequestDto): Long {
        return postsService.save(dto)
    }

}