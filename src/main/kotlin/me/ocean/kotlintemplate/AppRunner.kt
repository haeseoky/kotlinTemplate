package me.ocean.kotlintemplate

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class AppRunner: ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val test = Test1("haeseoky")

        println(test.name)
        test.name = "haha"
        println(test.name)


        val test2 = Test2()
        println(test2.name)
        test2.name = "haha2"
        println(test2.name)

        val main = Main("main", Sub("sub"))
        println(main)
    }
}


data class Main(
    val name: String,
    val sub: Sub,
)


data class Sub(
    val subName: String
)