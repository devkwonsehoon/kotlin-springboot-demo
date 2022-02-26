package com.example.kopringdemo.domain.posts

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/*
DB Layer 접근자.
JPA에서는 Repository라고 부르고 인터페이스로 생성한다.
생성한 후에 JpaRepository<Entity 클래스, PK타입>을 상속시키면 자동적으로 CRUD 메소드가 생성
*/
interface PostsRepository : JpaRepository<Posts, Long>{


    /**
     *  대규모 프로덕트의 경우에는 FK join이나 다른 조건을 사용하기 때문에
     *  querydsl, jooq, MyBatis 같은 조회용 프레임워크를 추가적으로 사용한다.
     *  jojoldu 님은 querydsl를 강추하신다.
     */
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") // @Query 어노테이션을 통해 JPA에서 제공하지 않는 메소드를 쿼리로 작성할수 있다.
    fun findAllDesc(): List<Posts>

}