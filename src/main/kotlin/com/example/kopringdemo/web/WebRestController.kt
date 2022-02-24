package com.example.kopringdemo.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebRestController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World!"
    }

}