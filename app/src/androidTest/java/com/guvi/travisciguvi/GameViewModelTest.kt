package com.guvi.travisciguvi

import androidx.lifecycle.viewmodel.compose.viewModel
import com.guvi.travisciguvi.uistate.GameViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GameViewModelTest {

    val gameViewModel = GameViewModel()

    @Test
    fun checkStartOfGame(){
        val gameUiState = gameViewModel.uiState.value
        val unScrambledWord = getUnScrambledWord(gameUiState.currentScrambledWord)
        assertNotEquals(unScrambledWord, gameUiState.currentScrambledWord)
        assertTrue(gameUiState.score == 0)
        assertFalse(gameUiState.isGuessedWordWrong)
        assertFalse(gameUiState.isGameOver)
    }

    @Test
    fun wordGuessedIsCorrect(){
        var currentGameUiState = gameViewModel.uiState.value
        val correctWord = getUnScrambledWord(currentGameUiState.currentScrambledWord)
        gameViewModel.updateUserGuess(correctWord)
        gameViewModel.checkUserGuess()
        currentGameUiState = gameViewModel.uiState.value
        assertEquals(20, currentGameUiState.score)
        assertEquals(false, currentGameUiState.isGuessedWordWrong)
        assertEquals(false, currentGameUiState.isGameOver)
    }

    @Test
    fun wordGuessedIsWrong(){
        var currentGameUiState = gameViewModel.uiState.value
        val inCorrectWord = "AndroidTestingIsGoodForDevelopment"
        gameViewModel.updateUserGuess(inCorrectWord)
        gameViewModel.checkUserGuess()
        currentGameUiState = gameViewModel.uiState.value
        assertEquals(true, currentGameUiState.isGuessedWordWrong)
        assertEquals(0, currentGameUiState.score)
    }

    @Test
    fun userChoosesToSkip(){
        var currentGameUiState = gameViewModel.uiState.value
        val correctWord = getUnScrambledWord(currentGameUiState.currentScrambledWord)
        gameViewModel.updateUserGuess(correctWord)
        gameViewModel.checkUserGuess()
        currentGameUiState = gameViewModel.uiState.value
        assertEquals(2, currentGameUiState.currentWordCount)
        gameViewModel.skipWord()
        currentGameUiState = gameViewModel.uiState.value
        assertEquals(4, currentGameUiState.currentWordCount)
    }
}