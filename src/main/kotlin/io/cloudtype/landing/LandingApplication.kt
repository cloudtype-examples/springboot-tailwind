package io.cloudtype.landing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LandingApplication

fun main(args: Array<String>) {
    runApplication<LandingApplication>(*args)
}
