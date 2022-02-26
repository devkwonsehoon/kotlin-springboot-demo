package com.example.kopringdemo.web

import com.example.kopringdemo.service.PostsService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class WebController (
    private val postsService: PostsService
) {

    @GetMapping("/")
    fun main(model: Model): String {
        model.addAttribute("posts", postsService.findAllDesc())
        return "index";
    }

}