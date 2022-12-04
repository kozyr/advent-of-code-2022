package com.kozyrenko.advent2022

import java.io.File

fun main(args: Array<String>) {
    var score = 0
    File("input/day3.txt").forEachLine { line ->
        val first = line.substring(0, line.length / 2)
        val second = line.substring(line.length / 2)

        first.toSet()
        score += first.toSet().intersect(second.toSet()).sumOf { day3Score(it) }

    }
    println(score)
}

fun day3Score(c: Char): Int {
    return if (c.isLowerCase()) {
        c - 'a' + 1
    } else if (c.isUpperCase()) {
        c - 'A' + 27
    } else 0
}

