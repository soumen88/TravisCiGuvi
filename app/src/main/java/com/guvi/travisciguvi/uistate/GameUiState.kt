package com.guvi.travisciguvi.uistate

data class GameUiState(
    val currentScrambledWord : String = "",
    val score : Int = 0,
    val currentWordCount : Int = 1,
    val isGuessedWordWrong : Boolean = false,
    val isGameOver : Boolean = false,
){
    override fun toString(): String {
        return "GameUiState(currentScrambledWord='$currentScrambledWord', score=$score, currentWordCount=$currentWordCount, isGuessedWordWrong=$isGuessedWordWrong, isGameOver=$isGameOver)"
    }
}