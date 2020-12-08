package com.paddy.bets

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BetsApplication

fun main(args: Array<String>) {
	runApplication<BetsApplication>(*args)
}
