package me.ocean.kotlintemplate

import me.ocean.kotlintemplate.entity.Person
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor

@SpringBootTest
@ActiveProfiles("local")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class PersonTest (
    private val personRepository: PersonRepository,
    private val personService: PersonService,
        ){

    @Test
    fun personTest(){
//        val person = Person(name = "ocean", age = 20)
        personService.create()
        personService.update()
        personService.delete()
//        personRepository.findAll().forEach { println(it) }

    }

}