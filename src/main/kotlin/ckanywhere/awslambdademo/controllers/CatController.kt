package ckanywhere.awslambdademo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cat")
class CatController {
    @GetMapping
    fun getCat() : String = "get cat"

    @PostMapping
    fun postCat(): String = "post cat"
}