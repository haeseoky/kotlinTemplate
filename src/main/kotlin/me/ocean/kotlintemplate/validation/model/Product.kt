package me.ocean.kotlintemplate.validation.model


import com.fasterxml.jackson.annotation.JsonUnwrapped
import javax.validation.Valid
import javax.validation.constraints.NotNull


data class Product (
    @field:NotNull
    val name: String?,
){
    @field:Valid
    @JsonUnwrapped
    var book: Book? = null
}

