package com.guvi.travisciguvi

const val MAX_NO_OF_WORDS = 10
const val SCORE_INCREASE = 20

// List with all the words for the Game
val allWords: Set<String> =
    setOf(
        "at",
        "sea",
        "home",
        "arise",
        "banana",
        "android",
        "birthday",
        "briefcase",
        "motorcycle",
        "cauliflower"
    )

///If you provide the word length then below variable will store the exact word depending on the number of characters
private val wordLengthMap : Map<Int, String> = allWords.associateBy({it.length}, {it})

internal fun getUnScrambledWord(scrambledWord : String) : String {
    val pickedWord = wordLengthMap[scrambledWord.length] ?: ""
    return pickedWord
}



