package com.kozyrenko.advent2022

import java.io.File

fun main(args: Array<String>) {

    val decrypt = mapOf(
        "A" to "R",
        "B" to "P",
        "C" to "S",
    )

    val toWin = mapOf(
        "R" to "P",
        "P" to "S",
        "S" to "R"
    )
    val toLose = toWin.map {  (key, value) -> value to key }.toMap()

    val points = mapOf(
        "R" to 1,
        "P" to 2,
        "S" to 3
    )

    var score = 0
    File("input/day2.txt").forEachLine { line ->
        val moves = line.trim().split(" ")

        val opp = decrypt[moves[0]]
        val roundScore = when (moves[1]) {
            "X" -> points[toLose[opp]]!!
            "Y" -> points[opp]!! + 3
            "Z" -> points[toWin[opp]]!! + 6
            else -> 0
        }
        score += roundScore
    }
    println(score)
}