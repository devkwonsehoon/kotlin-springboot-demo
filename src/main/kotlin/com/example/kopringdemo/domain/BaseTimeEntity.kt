package com.example.kopringdemo.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity {

    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장
    var createdAt: LocalDateTime = LocalDateTime.MIN
        private set

    @LastModifiedDate // 조회한 Entity의 값을 변경할 때 시간이 자동 저장
    var updatedAt: LocalDateTime = LocalDateTime.MIN
        private set
}