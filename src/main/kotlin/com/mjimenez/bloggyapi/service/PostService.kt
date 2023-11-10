package com.mjimenez.bloggyapi.service

import com.mjimenez.bloggyapi.dto.SavingPost
import com.mjimenez.bloggyapi.exception.DataValidationException
import com.mjimenez.bloggyapi.model.Post
import com.mjimenez.bloggyapi.repository.IPostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PostService : IPostService {
    private lateinit var repository: IPostRepository

    @Autowired
    fun setRepository(repository: IPostRepository) {
        this.repository = repository
    }

    override fun getAllPosts(query: String, page: Int, rows: Int): ResponseEntity<List<Post>> {
        val paging = PageRequest.of(page, rows)
        if (query != "")
            return ResponseEntity(repository.fetchAllSearching(query, query, query, paging).content, HttpStatus.OK)

        return ResponseEntity(repository.findAll(paging).content, HttpStatus.OK)
    }

    override fun savePost(post: SavingPost): ResponseEntity<Any> {
        if (!post.isValid())
            throw DataValidationException()
        repository.save(post.toPost())
        return ResponseEntity(HttpStatus.OK)
    }
}

interface IPostService {
    fun getAllPosts(query: String, page: Int, rows: Int = 10): ResponseEntity<List<Post>>

    fun savePost(post: SavingPost): ResponseEntity<Any>
}
