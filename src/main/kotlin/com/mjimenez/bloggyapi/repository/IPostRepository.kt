package com.mjimenez.bloggyapi.repository

import com.mjimenez.bloggyapi.model.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface IPostRepository : JpaRepository<Post,String > {
    @Query("SELECT p FROM Post p WHERE LOWER(p.title) LIKE %:title% OR LOWER(p.author) LIKE %:author% OR LOWER(p.content) LIKE %:content%")
    fun fetchAllSearching(
        @Param("title") title: String,
        @Param("author") author: String,
        @Param("content") content: String,
        pageable: Pageable
    ): Page<Post>
}
