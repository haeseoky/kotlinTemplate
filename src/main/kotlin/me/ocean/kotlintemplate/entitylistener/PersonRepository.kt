package me.ocean.kotlintemplate.entitylistener

import me.ocean.kotlintemplate.entitylistener.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository: JpaRepository<Person, Long> {
}