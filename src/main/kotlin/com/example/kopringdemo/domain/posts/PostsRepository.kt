package com.example.kopringdemo.domain.posts

import org.springframework.data.jpa.repository.JpaRepository

/*
DB Layer 접근자.
JPA에서는 Repository라고 부르고 인터페이스로 생성한다.
생성한 후에 JpaRepository<Entity 클래스, PK타입>을 상속시키면 자동적으로 CRUD 메소드가 생성
*/
interface PostsRepository : JpaRepository<Posts, Long>{
}