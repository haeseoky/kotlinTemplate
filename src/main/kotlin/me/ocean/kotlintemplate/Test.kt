package me.ocean.kotlintemplate

import org.springframework.stereotype.Component


interface Injection{

    fun doSomething()
}


@Component
class AImpl : Injection{
    override fun doSomething() {
        println("AImpl")
    }
}


@Component
class BImpl : Injection{
    override fun doSomething() {
        println("BImpl")
    }
}