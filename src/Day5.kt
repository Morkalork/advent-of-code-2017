package com.morkalork.adventOfCode
import java.io.File

class Day5 {

    fun getInput(): List<String> {
        val inputStream = File("src/Day5.txt").inputStream()
        return inputStream.bufferedReader().use { it.readLines() }
    }

    fun getSteps(input : List<String>, incAndDec : Boolean) : Int {

        val input = getInput()

        val instructions = input
                .map { it.toInt() }
                .toMutableList()

        var areWeThereYet = false
        var position = 0
        var steps = 0
        while (!areWeThereYet) {
            steps++
            val instruction = instructions[position]

            if(incAndDec && instruction >= 3) {
                instructions[position] = instructions[position] - 1
            } else {
                instructions[position] = instructions[position] + 1
            }

            position += instruction

            if (position >= instructions.size) {
                areWeThereYet = true // Finally kids! We did it!
            }
        }

        return steps
    }

    fun solve1() {
        val input = getInput()

        val steps = getSteps(input, false)

        println("We reached the end in $steps steps")
    }

    fun solve2() {
        val input = getInput()

        val steps = getSteps(input, true)

        println("We reached the end in $steps steps")
    }

    fun run() {
        solve1()
        solve2()
    }
}