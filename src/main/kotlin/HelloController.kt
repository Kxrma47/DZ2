package com.example.demo.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/")
    fun index(): String {
        return "Welcome to the Spring Boot Application!"
    }
    @GetMapping("/hello-all")
    fun helloAll(): String = "Hello, Everyone!"

    @GetMapping("/hello-user")
    fun helloUser(): String = "Hello, User!"

    @GetMapping("/hello-admin")
    fun helloAdmin(): String = "Hello, Admin!"

    @GetMapping("/error")
    fun error(): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The requested page was not found.")
    }
}
