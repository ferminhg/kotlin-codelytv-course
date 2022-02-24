package com.codely.demo

import java.time.LocalDate

fun main() {
    println("Please enter a date <yyyy-MM-dd>")
    val readLine: String? = null
    val input = LocalDate.parse(readLine ?: "1982-11-21")
    readLine?.let {
        val output = LocalDate.parse(it)
        println("You entered: $output")
    }
//    val input = LocalDate.parse(readLine!!) // el !! es para que no sea null
    println("You wrote $input ${input.dayOfWeek}")
}
