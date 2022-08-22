package me.ocean.kotlintemplate

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import me.ocean.kotlintemplate.validation.model.Book
import me.ocean.kotlintemplate.validation.model.Product
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class ValidationTest(
    private val mockMvc: MockMvc,

) {
    val mapper: ObjectMapper = jacksonObjectMapper()

    @Test
    fun test1() {
        val param = Product(
            name = "null"
        )
            .apply {
                book = Book(
                    name = "null", page = 0
                )
            }

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