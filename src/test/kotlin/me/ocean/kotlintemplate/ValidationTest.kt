package me.ocean.kotlintemplate

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@WebMvcTest
@AutoConfigureMockMvc
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class ValidationTest (
    private val  mockMvc: MockMvc
        ){



    val mapper: ObjectMapper = ObjectMapper().registerModule(JavaTimeModule())


    @Test
    fun test1() {
        val param = Product(
            name = "null", price = 1.0, tf = true, age = 10, list = listOf()
        )

        val data = mapper.writeValueAsString(param)
        println(data)

        val contentAsString = mockMvc.post("/api/test") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(param)

        }.andExpect {
            status { isOk() }
        }.andReturn().response.contentAsString

        println(contentAsString)
    }
}