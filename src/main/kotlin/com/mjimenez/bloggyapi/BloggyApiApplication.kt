package com.mjimenez.bloggyapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BloggyApiApplication

fun main(args: Array<String>) {
    runApplication<BloggyApiApplication>(*args)
}
