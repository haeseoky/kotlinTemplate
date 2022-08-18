package me.ocean.kotlintemplate.entitylistener.entity

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "person_history")
class PersonHistory (

    @Column(name = "operation_type")
    var operationType: String,

    @Column(name = "person_id")
    val personId: Long,

    @Column(name = "before_name")
    val beforeName: String,

    @Column(name = "before_age")
    val beforeAge: Int,

    @Column(name = "after_name")
    val afterName: String,

    @Column(name = "after_age")
    val afterAge: Int,


){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @CreationTimestamp
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
}