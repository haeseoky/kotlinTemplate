package me.ocean.kotlintemplate.jpa.entity

import me.ocean.kotlintemplate.AbstractSpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JpaServiceTest(
    private val jpaService: JpaService,
    private val childRepository: ChildRepository,
) : AbstractSpringBootTest() {

    @Test
    fun test(){
        val parent = Parent(name = "parent")
        val saveParent = jpaService.saveParent(parent)
        val saveChild = jpaService.saveChild(Child(name = "child", parent = parent))

        println("saveChild.parent.id:${saveChild.parent.id}")
        println("parent.id:${parent.id}")
        assertThat(saveChild.parent.id).isEqualTo(parent.id)



    }
}