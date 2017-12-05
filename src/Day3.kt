package com.morkalork.adventOfCode

class Day3 {

    fun getSide(input: Double) : Double{
        val root = Math.ceil(Math.sqrt(input))
        return if ((root % 2.0) != 0.0) root else (root + 1 )
    }
    fun getSteps(input : Int) : Double {
        val side = getSide(input.toDouble())
        val steps = (side - 1) / 2
        val axises = 0.until(4).map { Math.pow(side, 2.0) - ((side - 1) * it) - Math.floor(side / 2) }
        val totalSteps = axises.map { Math.abs(it - input) }

        return totalSteps.min()!! + steps
    }

    fun solve1() {
        val steps = getSteps(361527)
        println("Steps:  $steps")
    }

    fun solve2() {

    }

    fun run() {
        solve1()
        solve2()
    }
}