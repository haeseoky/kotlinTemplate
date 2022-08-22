package me.ocean.kotlintemplate.jpa.entity

import javax.persistence.*

@Entity
@Table(name = "child")
class Child(
    @Column(name = "name")
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    val parent: Parent
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}