package com.kozyrenko.advent2022

import java.io.File

fun main(args: Array<String>) {
    val points = mapOf(
        "R" to 1,
        "P" to 2,
        "S" to 3
    )
    val wins = mapOf(
        "R" to "S",
        "P" to "R",
        "S" to "P"
    )
    val decrypt = mapOf(
        "A" to "R",
        "B" to "P",
        "C" to "S",
        "X" to "R",
        "Y" to "P",
        "Z" to "S"
    )
    var score = 0
    File("input/day2.txt").forEachLine { line ->
        val moves = line.trim().split(" ")

        val opp = decrypt[moves[0]]
        val me = decrypt[moves[1]]

        if (wins[opp] == me) {
            score += 0
        } else if (wins[me] == opp) {
            score += 6
        } else {
            score += 3
        }
        score += points[me]!!
    }
    println(score)
}