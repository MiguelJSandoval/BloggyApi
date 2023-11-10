package com.mjimenez.bloggyapi.controller

import com.mjimenez.bloggyapi.dto.SavingPost
import com.mjimenez.bloggyapi.service.IPostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/posts")
class PostController {

    private lateinit var service: IPostService

    @Autowired
    fun setService(service: IPostService) {
        this.service = service
    }

    @PostMapping
    fun savePost(@RequestBody post: SavingPost): Any = service.savePost(post)

    
}