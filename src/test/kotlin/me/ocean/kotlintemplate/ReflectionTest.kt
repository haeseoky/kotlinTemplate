package me.ocean.kotlintemplate

import me.ocean.kotlintemplate.entitylistener.entity.Person
import org.junit.jupiter.api.Test

class ReflectionTest {
    @Test
    fun reflectionTest(){
        val storageItemUpdateModel = Person(
            name = "", age = 0
        )
        val clazz = storageItemUpdateModel.javaClass

        clazz.declaredFields.forEach {
            it.isAccessible = true
            println(it.name)
            println(it[storageItemUpdateModel])
        }


    }
}