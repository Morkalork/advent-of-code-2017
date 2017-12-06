package com.morkalork.adventOfCode

class Day6 {

    fun getInput(): MutableList<Int> {

        // val input = "0\t2\t7\t0" // Test input
        val input = "11\t11\t13\t7\t0\t15\t5\t5\t4\t4\t1\t1\t7\t1\t15\t11"

        return input
                .split("\\t".toRegex())
                .map { it.toInt() }
                .toMutableList()
    }

    fun solve1() {
        val blocks = getInput()
        var done = false
        val passedBlocks = mutableListOf<List<Int>>()
        var count = 0
        var matchedIndex = -1
        while (!done) {
            count++
            var topDog = blocks.max() ?: -1

            var indexer = blocks.indexOf(topDog) // Returns the first index of our "top dog"
            blocks[indexer] = 0

            while (topDog > 0) {
                indexer++
                if (indexer >= blocks.size) {
                    indexer = 0
                }

                blocks[indexer]++
                topDog--
            }

            // println("$blocks, $passedBlocks")
            if (passedBlocks.contains(blocks)) {
                done = true
                matchedIndex = passedBlocks.indexOf(blocks) + 1
            }

            val newBlock = blocks.toList()
            passedBlocks.add(newBlock)
        }

        println("Solution 1: ${passedBlocks.size}")
        println("Solution 2: ${passedBlocks.size - matchedIndex} ($matchedIndex)")
    }

    fun solve2() {
    }

    fun run() {
        solve1()
        solve2()
    }
}