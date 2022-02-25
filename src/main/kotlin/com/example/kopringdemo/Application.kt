package com.example.kopringdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing // JPA Auditing 활성화!
@SpringBootApplication
class KopringdemoApplication

fun main(args: Array<String>) {
    runApplication<KopringdemoApplication>(*args)
}
