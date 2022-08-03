package me.ocean.kotlintemplate


import javax.validation.constraints.Max
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class Product (
    @field:NotNull
    val name: String?,

    @field:NotNull
    val price: Double?,

    @field:NotNull
    val tf: Boolean?,

    @field:NotNull
    @field:Max(value = 10, message = "Max 10")
    val age: Int?,

    @field:NotNull
    val list: List<String>?

    )