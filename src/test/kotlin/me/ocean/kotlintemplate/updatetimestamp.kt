package me.ocean.kotlintemplate

import me.ocean.kotlintemplate.jpa.entity.JpaService
import me.ocean.kotlintemplate.jpa.entity.Parent
import me.ocean.kotlintemplate.jpa.entity.ParentRepository
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor


@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class updatetimestamp (
    private val jpaService: JpaService,
    private val parentRepository: ParentRepository,
        ){

    @Test
    fun test(){
       jpaService.save()
    }

    @Test
    fun test2222(){
        val parent = Parent(name = "test")
        println(parent)
        val save = parentRepository.save(parent)



        val update = jpaService.update(save.id)

        println(update)
    }



}