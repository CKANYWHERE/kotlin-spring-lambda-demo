package ckanywhere.awslambdademo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dog")
class DogController {
    @GetMapping
    fun getDog(): String = "get dog"

    @PostMapping
    fun postDog(): String = "post dog"
}