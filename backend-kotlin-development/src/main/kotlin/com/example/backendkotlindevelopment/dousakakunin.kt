package com.example.backendkotlindevelopment

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class dousakakunin {
    @GetMapping("/")
    fun helloWorld(): String {
        return "Hello World"
    }
}