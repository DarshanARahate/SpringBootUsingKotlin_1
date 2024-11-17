package com.example.koltin.demo.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleApi1 {

    @GetMapping("abc")
    public fun sayHello(): String {
        return "Hello";
    }

}