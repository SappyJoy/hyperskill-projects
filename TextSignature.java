package signature

import java.io.File
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter name and surname: ")
    val username = scanner.nextLine()
    print("Enter person's status: ")
    val status = scanner.nextLine()

    drawRomanName(username, status)
}

fun drawRomanName(name: String, status: String) {
    val romanLetters = getMapFont("/home/sappy-joy/fonts/roman.txt")
    val mediumLetters = getMapFont("/home/sappy-joy/fonts/medium.txt")
    val romanHeight = 10
    val mediumHeight = 3

    var nameLength = 0
    for (element in name) {
        if (element == ' ') {
            nameLength += 10
            continue
        }
        nameLength += romanLetters[element]!![0].length
    }

    var statusLength = 0
    for (element in status) {
        if (element == ' ') {
            statusLength += 5
            continue
        }
        statusLength += mediumLetters[element]!![0].length
    }

    val length = max(nameLength, statusLength) + 3

    for (i in 0 until length + 5) {
        print("8")
    }
    println()

    for (i in 0 until romanHeight) {
        print("88")
        for (j in 0 until (length - nameLength + 1) / 2)
            print(" ")
        for (letter in name) {
            if (letter == ' ') {
                print("          ")
                continue
            }
            print(romanLetters[letter]!![i])
        }
        for (j in 0 until (length - nameLength + 2) / 2)
            print(" ")
        print("88")
        println()
    }

    for (i in 0 until mediumHeight) {
        print("88")
        for (j in 0 until (length - statusLength + 1) / 2)
            print(" ")
        for (letter in status) {
            if (letter == ' ') {
                print("     ")
                continue
            }
            print(mediumLetters[letter]!![i])
        }
        for (j in 0 until (length - statusLength + 2) / 2)
            print(" ")
        print("88")
        println()
    }

    for (i in 0 until length + 5) {
        print("8")
    }
}

fun getMapFont(path: String): Map<Char, Array<String>> {
    val sc = Scanner(File(path))
    val letters = mutableMapOf<Char, Array<String>>()

    val height = sc.nextInt()
    val lettersCount = sc.nextInt()

    for (k in 0 until lettersCount) {
        val letter = sc.next()[0]
        val width = sc.nextInt()
        sc.nextLine()
        var drawnLetter: MutableList<String> = mutableListOf<String>()

        for (line in 0 until height) {
            drawnLetter.add(sc.nextLine())
        }
        letters.put(letter, drawnLetter.toTypedArray())
    }

    return letters
}

fun drawStarName(name: String, status: String) {
    val letters = mapOf(
        ('a' to arrayOf("____", "|__|", "|  |")),
        ('b' to arrayOf("___ ", "|__]", "|__]")),
        ('c' to arrayOf("____", "|   ", "|___")),
        ('d' to arrayOf("___ ", "|  \\", "|__/")),
        ('e' to arrayOf("____", "|___", "|___")),
        ('f' to arrayOf("____", "|___", "|   ")),
        ('g' to arrayOf("____", "| __", "|__]")),
        ('h' to arrayOf("_  _", "|__|", "|  |")),
        ('i' to arrayOf("_", "|", "|")),
        ('j' to arrayOf(" _", " |", "_|")),
        ('k' to arrayOf("_  _", "|_/ ", "| \\_")),
        ('l' to arrayOf("_   ", "|   ", "|___")),
        ('m' to arrayOf("_  _", "|\\/|", "|  |")),
        ('n' to arrayOf("_  _", "|\\ |", "| \\|")),
        ('o' to arrayOf("____", "|  |", "|__|")),
        ('p' to arrayOf("___ ", "|__]", "|   ")),
        ('q' to arrayOf("____", "|  |", "|_\\|")),
        ('r' to arrayOf("____", "|__/", "|  \\")),
        ('s' to arrayOf("____", "[__ ", "___]")),
        ('t' to arrayOf("___", " | ", " | ")),
        ('u' to arrayOf("_  _", "|  |", "|__|")),
        ('v' to arrayOf("_  _", "|  |", " \\/ ")),
        ('w' to arrayOf("_ _ _", "| | |", "|_|_|")),
        ('x' to arrayOf("_  _", " \\/ ", "_/\\_")),
        ('y' to arrayOf("_   _", " \\_/ ", "  |  ")),
        ('z' to arrayOf("___ ", "  / ", " /__")),
        (' ' to arrayOf("    ", "    ", "    ")))

    var length = 0
    for (char in name) {
        length += (letters.get(char.toLowerCase())!![0].length + 1)
    }
    length += 3

    val nameLength = length - 4

    length = Math.max(length, status.length + 4)

    for (i in 0 until length + 2)
        print("*")

    println()

    for (i in 0..2) {
        print("*")
        for (j in 0 until (length - nameLength) / 2)
            print(" ")
        for (char in name) {
            print(letters.get(char.toLowerCase())!![i])
            print(" ")
        }
        for (j in 0 until (length - nameLength + 1) / 2 - 1)
            print(" ")
        print("*")
        println()
    }

    print("*")
    for (i in 0 until (length - status.length) / 2)
        print(" ")
    print(status)
    for (i in 0 until (length - status.length + 1) / 2)
        print(" ")
    print("*")
    println()

    for (i in 0 until length + 2)
        print("*")
}
