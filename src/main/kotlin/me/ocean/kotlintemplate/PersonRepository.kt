package me.ocean.kotlintemplate

import me.ocean.kotlintemplate.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository: JpaRepository<Person, Long> {
}