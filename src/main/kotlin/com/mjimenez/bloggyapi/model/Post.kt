package com.mjimenez.bloggyapi.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import lombok.Getter
import lombok.Setter
import org.hibernate.Hibernate
import java.util.Date
import java.util.UUID

@Entity
@Getter
@Setter
@Table(name = "posts")
open class Post {
    @Id
    @Column(name="post_id", length = 36)
    open var postId: String = UUID.randomUUID().toString()

    @Column(name = "title", length = 255)
    open var title: String? = null

    @Column(name = "author", length = 255)
    open var author: String? = null

    @Temporal(TemporalType.DATE)
    @Column(name = "date", length = 255)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    open var date: Date? = null

    @Column(name = "content", columnDefinition = "TEXT")
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
