package me.ocean.kotlintemplate.jpa.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "parent")
class Parent(
    @Column(name = "name")
    var name: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @CreationTimestamp
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()

    @UpdateTimestamp
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @Column
    var deletedAt: LocalDateTime? = null

    override fun toString(): String {
        return "Parent(id=$id, name=$name, createdAt=$createdAt, updatedAt=$updatedAt, deletedAt=$deletedAt)"
    }
}