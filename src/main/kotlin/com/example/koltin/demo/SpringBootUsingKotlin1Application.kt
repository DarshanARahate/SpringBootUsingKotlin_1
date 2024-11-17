package com.example.koltin.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootUsingKotlin1Application

fun main(args: Array<String>) {
	runApplication<SpringBootUsingKotlin1Application>(*args)
}
