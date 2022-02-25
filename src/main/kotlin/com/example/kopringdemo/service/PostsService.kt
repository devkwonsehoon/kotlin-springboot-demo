package com.example.kopringdemo.service

import com.example.kopringdemo.domain.posts.PostsRepository
import com.example.kopringdemo.web.dto.PostsSaveRequestDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostsService (
    private val postsRepository: PostsRepository
) {

    /*
    DB에 데이터를 등록/삭제/수정하는 Service 메서드들은 모두 @Transactional 메서드를 가져간다.
    이는 컨트롤러와 서비스의 역할을 분리하기 위함이다.
    비즈니스 로직과 트랜잭션은 모두 서비스에게 맡기고, 뷰와 연동되는 부븐은 컨트롤러에서 담당한다.

    트랜잭션이란,
    해당 메서드내에서 Exception이 터지게 되면 해당 메서드에서 이루어진 DB 작업들을 전부 초기화 시키는 것
    * */
    @Transactional
    fun save(dto: PostsSaveRequestDto): Long { // Service층에서는 Entity를 바로 받지 않고 DTO를 받아 저장한다.
        return postsRepository.save(dto.toEntity()).id
    }

}