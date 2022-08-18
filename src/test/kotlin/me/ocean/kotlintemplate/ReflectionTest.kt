package me.ocean.kotlintemplate

import me.ocean.kotlintemplate.validation.entity.Product
import org.junit.jupiter.api.Test

class ReflectionTest {
    @Test
    fun reflectionTest(){
        val storageItemUpdateModel = Product(
            name = "ocean", price = 10000.0, tf = null, age = 10, list = listOf("a", "b", "c")
        )
        val clazz = storageItemUpdateModel.javaClass

        clazz.declaredFields.forEach {
            it.isAccessible = true
            println(it.name)
            println(it[storageItemUpdateModel])
        }


    }
}