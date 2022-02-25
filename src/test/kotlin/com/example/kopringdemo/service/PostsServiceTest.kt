package com.example.kopringdemo.service

import com.example.kopringdemo.domain.posts.PostsRepository
import com.example.kopringdemo.web.dto.PostsSaveRequestDto
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PostsServiceTest @Autowired constructor(
    private val postsService: PostsService,
    private val postsRepository: PostsRepository
){

    @AfterEach
    fun cleanUp() {
        postsRepository.deleteAll()
    }

    @Test
    fun `DTO 데이터가 Posts 테이블에 저장됨`() {
        // given
        val dto: PostsSaveRequestDto = PostsSaveRequestDto("테스트 게시글", "테스트 내용", "devkwonsehoon")

        // when
        postsService.save(dto)

        // then
        val post = postsRepository.findAll().first()
        assertThat(post.title).isEqualTo(dto.title)
        assertThat(post.content).isEqualTo(dto.content)
        assertThat(post.author).isEqualTo(dto.author)
    }

}