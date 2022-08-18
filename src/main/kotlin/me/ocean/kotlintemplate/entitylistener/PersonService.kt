package me.ocean.kotlintemplate.entitylistener

import me.ocean.kotlintemplate.entitylistener.entity.Person
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PersonService (
    private val personRepository: PersonRepository,
        ){
    fun create(){
        personRepository.save(
            Person(
            name = "ocean",
            age = 18

        )
        )
    }

    fun update(){
        val first = personRepository.findAll().first()
        first.age = 100
        personRepository.saveAndFlush(first)
    }

    fun delete(){
        val first = personRepository.findAll().first()
        personRepository.delete(first)
    }
}