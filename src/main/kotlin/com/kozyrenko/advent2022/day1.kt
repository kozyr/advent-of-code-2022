package com.kozyrenko.advent2022

import java.io.File

fun main(args: Array<String>) {
    var currentSum = 0

    var first = Int.MIN_VALUE
    var second = Int.MIN_VALUE
    var third = Int.MIN_VALUE
    File("input/day1.txt").forEachLine { line ->
        if (line.isBlank()) {
            if (currentSum > first) {
                third = second
                second = first
                first = currentSum
            } else if (currentSum > second && currentSum != first) {
                third = second
                second = currentSum
            } else if (currentSum > third && currentSum != second) {
                third = currentSum
            }
            currentSum = 0
        } else {
            currentSum += line.toInt()
        }
    }

    println("top: $first")
    println("top3: ${first + second + third}")
}