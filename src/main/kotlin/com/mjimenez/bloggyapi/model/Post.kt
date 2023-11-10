package com.mjimenez.bloggyapi.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.Hibernate
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "posts")
open class Post {
    @Id
    @Column(name="post_id", length = 36)
    open var postId: String = UUID.randomUUID().toString()

    @Column(name = "title", length = 255)
    open var title: String? = null

    @Column(name = "author", length = 255)
    open var author: String? = null

    @Column(name = "date", length = 255)
    open var date: Instant? = null

    @Column(name = "content")
    open var content: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Post

        return postId != other.postId
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}
