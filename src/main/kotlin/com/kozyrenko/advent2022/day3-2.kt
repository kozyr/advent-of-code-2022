package com.kozyrenko.advent2022

import java.io.File

fun main(args: Array<String>) {
    var score = 0
    val group = mutableListOf<String>()
    File("input/day3.txt").forEachLine { line ->
        group.add(line)
        if (group.size % 3 == 0) {
            score += day3Score(
                group.map(String::toSet).reduce {
                        acc, set -> acc.intersect(set)
                }.first()
            )
            group.clear()
        }
    }

    println(score)
}
