package com.example.kopringdemo.web

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate


@SpringBootTest(webEnvironment = RANDOM_PORT)
class WebControllerTest @Autowired constructor (
    private val restTemplate: TestRestTemplate
){
    @Test
    fun `메인페이지 로딩`() {
        // when
        val body = restTemplate.getForObject("/", String::class.java)

        // then
        assertThat(body).contains("스프링부트로 시작하는 웹 서비스")
    }
}