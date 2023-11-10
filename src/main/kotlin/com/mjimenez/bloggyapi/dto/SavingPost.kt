package com.mjimenez.bloggyapi.dto

import com.mjimenez.bloggyapi.model.Post
import java.util.*

data class SavingPost(
    val title: String,
    val author: String,
    val content: String
) {
    fun isValid(): Boolean {
        return title.isNotEmpty() && author.isNotEmpty() && content.isNotEmpty()
    }

    fun toPost(): Post {
        val post = Post()
        post.title = title
        post.author = author
        post.content = content
        post.date = Date()
        return post
    }
}
