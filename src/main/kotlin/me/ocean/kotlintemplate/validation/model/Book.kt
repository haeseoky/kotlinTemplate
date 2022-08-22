package me.ocean.kotlintemplate.validation.model

import javax.validation.constraints.NotNull


data class Book(
    @field:NotNull
    val name: String?,
    @field:NotNull
    val page: Int?,
)