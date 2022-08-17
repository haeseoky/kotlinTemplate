package me.ocean.kotlintemplate.entity

import me.ocean.kotlintemplate.PersonListener
import javax.persistence.*

@Entity
@Table(name = "person")
@EntityListeners(PersonListener::class)
class Person (
    @Column(name = "name")
    var name: String,

    @Column(name = "age")
    var age: Int,
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0


    @Transient
    var oldName: String = ""

    @Transient
    var oldAge: Int = 0


}