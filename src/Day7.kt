package com.morkalork.adventOfCode
import java.io.File

class Tower {
    var name: String = ""
    var weight: Int = -1
    var childrenNames: List<String> = listOf<String>()

}

class Day7 {

    fun getInput(): List<String> {
        val inputStream = File("src/Day7.txt").inputStream()
        return inputStream.bufferedReader().use { it.readLines() }
    }

    fun getNodeStructure(input: List<String>) : List<Tower> {
        return input
                .map{it.split("[->]".toRegex())}
                .map(fun(split: List<String>) : Tower {
                    val leftSplit = split[0].split("\\s".toRegex())
                    val w = leftSplit[1].substring(1, leftSplit[1].length -1).toInt()
                    val rightSplit = if (split.size > 2) split[2].split("\\s".toRegex()) else listOf()
                    return Tower().apply {
                        name = leftSplit[0]
                        weight = w
                        childrenNames = rightSplit.filter{it != ""}.map{it.replace(",", "")}
                    }
                })
    }

    fun getOrphan() : Tower? {
        val input = getInput()
        val nodeStructure = getNodeStructure(input)
        return nodeStructure.find{outer -> nodeStructure.none{inner -> inner.childrenNames.contains(outer.name)}}
    }

    fun solve1() {
        val orphan = getOrphan()
        println(orphan!!.name)

    }

    fun solve2() {

    }

    fun run() {
        solve1()
        solve2()
    }
}