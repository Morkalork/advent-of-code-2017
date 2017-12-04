import com.morkalork.adventOfCode.*
import java.io.File

class Day4 {

    fun isLineValid(line: String) : Boolean {
        val chunks = line.split("\\s".toRegex())
        return chunks.none { chunk -> chunks.count{it == chunk} > 1 }
    }

    fun getInput() : String {
        val inputStream = File("src/Day4.txt").inputStream()
        return inputStream.bufferedReader().use{it.readText()}
    }

    fun solve1() {
        println("DAY 4, part 1: ")
        println("--------------")
        val valid = "aa bb cc dd ee"
        val notValid = "aa bb cc dd aa"

        println("This should be valid: ${isLineValid(valid)}")
        println("This should NOT be valid: ${isLineValid(notValid)}")

        val lines = getInput().split("\\n".toRegex())
        val validLines = lines.count{isLineValid(it)}

        println("Valid lines all in all: $validLines")
    }

    fun sortLine(line: String) : String{
        return line.split("".toRegex()).sorted().joinToString("")
    }

    fun doesLineContainAnagrams(input: String) : Boolean {
        val words = input.split("\\s".toRegex())
        println("WORDS: $words")
        for(word in words) {
            val sortedWord = sortLine(word)
            val sortedWords = words.map{sortLine(it)}
            println("Sorted word: $sortedWord, sortedWords: $sortedWords}, count: ${sortedWords.count{it == sortedWord} }")
            if(sortedWords.count{it == sortedWord} > 1) {
                return false
            }
        }

        return true
    }

    fun solve2() {
        println("DAY 4, part 2: ")
        println("--------------")
        val valid = "a ab abc abd abf abj"
        val notValid = "oiii ioii iioi iiio"

        println("This should be valid: ${doesLineContainAnagrams(valid)}")
        println("This should NOT be valid: ${doesLineContainAnagrams(notValid)}")

        val lines = getInput().split("\\n".toRegex())
        val validLines = lines.count{doesLineContainAnagrams(it)}
        println("Valid lines all in all: $validLines")
    }

    fun run() {
        solve1()
        solve2()
    }
}