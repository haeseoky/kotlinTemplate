package me.ocean.kotlintemplate

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Component
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class InjectionTestCodeTest(
    private val aImpl: InjectionTestCode,
//    private val bImpl: InjectionTestCode,
) {
    @Test
    fun test() {
        aImpl.doSomething()
//        bImpl.doSomething()
    }
}


interface InjectionTestCode{

    fun doSomething()
}


@Component
class AImpl : InjectionTestCode{
    override fun doSomething() {
        println("AImpl")
    }
}


@Component
class BImpl : InjectionTestCode{
    override fun doSomething() {
        println("BImpl")
    }
}