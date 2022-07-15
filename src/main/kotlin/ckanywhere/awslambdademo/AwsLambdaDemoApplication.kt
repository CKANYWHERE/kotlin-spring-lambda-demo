package ckanywhere.awslambdademo

import ckanywhere.awslambdademo.controllers.CatController
import ckanywhere.awslambdademo.controllers.DogController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.web.servlet.HandlerAdapter
import org.springframework.web.servlet.HandlerMapping
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping

@SpringBootApplication
@Import(
    CatController::class,
    DogController::class
)
class AwsLambdaDemoApplication

fun main(args: Array<String>) {
    runApplication<AwsLambdaDemoApplication>(*args)
}

@Bean
fun handlerMapping() : HandlerMapping = RequestMappingHandlerMapping()

@Bean
fun handlerAdapter(): HandlerAdapter = RequestMappingHandlerAdapter()