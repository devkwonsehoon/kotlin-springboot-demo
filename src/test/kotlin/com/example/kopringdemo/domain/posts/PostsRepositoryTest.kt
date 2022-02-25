package com.example.kopringdemo.domain.posts

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class PostsRepositoryTest @Autowired constructor(
    private val postsRepository: PostsRepository
) {

    @AfterEach
    fun cleanUp() {
        postsRepository.deleteAll()
    }

    @Test
    fun `게시글저장 불러오기`() {
        val testingTitle = "게시글 제목"
        val testingContent = "게시글 내용"

        /*
        given
        테스트 기반 환경을 구축하는 단계
        */
        postsRepository.save(Posts(testingTitle, testingContent, "devkwonsehoon"))

        /*
        when
        테스트 하고자 하는 행위를 선언
        여기서는 Posts가 DB에 insert 되는 것을 확인하기 위함
        */
        val postsList = postsRepository.findAll()

        /*
        then
        테스트 결과 검증
        실제로 DB에 insert 되었는지 확인하기 위해 조회후, 입력된 값 확인
        */
        postsList.first().run {
            assertThat(title).isEqualTo(testingTitle)
            assertThat(content).isEqualTo(testingContent)
            assertThat(author).isEqualTo("devkwonsehoon")
        }

    }

    @Test
    fun `BaseTimeEntity 등록`() {
        // given
        val testingTime: LocalDateTime = LocalDateTime.now()
        postsRepository.save(Posts("게시글 제목", "게시글 내용", "devkwonsehoon"))

        // when
        val postsList = postsRepository.findAll()

        // then
        postsList.first().run {
            assertThat(createdAt).isAfter(testingTime)
            assertThat(updatedAt).isAfter(testingTime)
        }
    }
}