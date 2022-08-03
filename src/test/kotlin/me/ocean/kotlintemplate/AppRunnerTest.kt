package me.ocean.kotlintemplate

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class AppRunnerTest{

    @Test
    fun test(){
        val bean = ExtendableBean("My bean")

//        bean.properties = mapOf()
        bean.properties = mapOf("attr1" to "val1", "attr2" to "val2")

        val result: String = ObjectMapper().writeValueAsString(bean)

        assertThat(result).contains("attr1")
        assertThat(result).contains("val1")
    }
}

class ExtendableBean (var name: String? = null){


    @get:JsonAnyGetter
    var properties: Map<String, String>? = null
}