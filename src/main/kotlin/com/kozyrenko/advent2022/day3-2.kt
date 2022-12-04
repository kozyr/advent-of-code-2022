package com.kozyrenko.advent2022

import java.io.File

fun main(args: Array<String>) {
    var score = 0
    val group = mutableListOf<String>()
    File("input/day3.txt").forEachLine { line ->
        group.add(line)
        if (group.size % 3 == 0) {
            score += scoreGroup(group)
            group.clear()
        }
    }

    println(score)
}

fun scoreGroup(group: List<String>): Int {
    return score(group.map(String::toCharSet).reduce {
            acc, set -> acc.intersect(set)
    }.first())
}
