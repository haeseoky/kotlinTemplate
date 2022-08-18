package me.ocean.kotlintemplate.validation



import me.ocean.kotlintemplate.validation.entity.Product
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class TestController {
    @PostMapping("/test")
    fun test(@Valid @RequestBody product: Product){

        println("test call")
    }
}