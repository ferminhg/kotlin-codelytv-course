package com.codely.demo

import java.time.LocalDate
import java.time.Period
import kotlin.system.exitProcess

fun main() {
    println("Please enter a date <yyyy-MM-dd>")

    supportNullableString(readLine()).takeUnless {
        it.isNullOrEmpty() || it.isNullOrBlank()
    }?.let {
        LocalDate.parse(it)
    }.apply {
        if (this == null) {
            println("Invalid date")
            exitProcess(1)
        }
    }?.also { input ->
        println("You wrote $input")
    }?.run {
        calculateDifference()
    }
}

fun supportNullableString(line: String?) = line

private fun LocalDate.calculateDifference() = with(Period.between(this, LocalDate.now())) {
    when {
        years < 18 -> println("You are too young")
        years > 0 -> println("You are $years years old")
        months > 0 -> println("You are $months months old")
        days > 0 -> println("You are $days days old")
        else -> println("You are the same day")
    }
}
