package com.guvi.travisciguvi.uistate

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private val TAG = "GameViewModel"
    private lateinit var currentWord : String
    private val _gameUiState = MutableStateFlow(GameUiState())
    val uiState : StateFlow<GameUiState> = _gameUiState.asStateFlow()
    private val usedWords : MutableSet<String> = mutableSetOf()
    var userGuess by mutableStateOf("")
        private set

/*    val allWords: Set<String> =
        setOf(
            "animal",
            "auto",
            "anecdote",
            "alphabet",
            "all",
            "awesome",
            "arise",
            "balloon",
            "basket",
            "bench",
            "best",
            "birthday",
            "book",
            "briefcase",
            "camera",
            "camping",
            "candle",
            "cat",
            "cauliflower",
            "chat",
            "children",
            "class",
            "classic",
            "classroom",
            "coffee",
            "colorful",
            "cookie",
            "creative",
            "cruise",
            "dance",
            "daytime",
            "dinosaur",
            "doorknob",
            "dine",
            "dream",
            "dusk",
            "eating",
            "elephant",
            "emerald",
            "eerie",
            "electric",
            "finish",
            "flowers",
            "follow",
            "fox",
            "frame",
            "free",
            "frequent",
            "funnel",
            "green",
            "guitar",
            "grocery",
            "glass",
            "great",
            "giggle",
            "haircut",
            "half",
            "homemade",
            "happen",
            "honey",
            "hurry",
            "hundred",
            "ice",
            "igloo",
            "invest",
            "invite",
            "icon",
            "introduce",
            "joke",
            "jovial",
            "journal",
            "jump",
            "join",
            "kangaroo",
            "keyboard",
            "kitchen",
            "koala",
            "kind",
            "kaleidoscope",
            "landscape",
            "late",
            "laugh",
            "learning",
            "lemon",
            "letter",
            "lily",
            "magazine",
            "marine",
            "marshmallow",
            "maze",
            "meditate",
            "melody",
            "minute",
            "monument",
            "moon",
            "motorcycle",
            "mountain",
            "music",
            "north",
            "nose",
            "night",
            "name",
            "never",
            "negotiate",
            "number",
            "opposite",
            "octopus",
            "oak",
            "order",
            "open",
            "polar",
            "pack",
            "painting",
            "person",
            "picnic",
            "pillow",
            "pizza",
            "podcast",
            "presentation",
            "puppy",
            "puzzle",
            "recipe",
            "release",
            "restaurant",
            "revolve",
            "rewind",
            "room",
            "run",
            "secret",
            "seed",
            "ship",
            "shirt",
            "should",
            "small",
            "spaceship",
            "stargazing",
            "skill",
            "street",
            "style",
            "sunrise",
            "taxi",
            "tidy",
            "timer",
            "together",
            "tooth",
            "tourist",
            "travel",
            "truck",
            "under",
            "useful",
            "unicorn",
            "unique",
            "uplift",
            "uniform",
            "vase",
            "violin",
            "visitor",
            "vision",
            "volume",
            "view",
            "walrus",
            "wander",
            "world",
            "winter",
            "well",
            "whirlwind",
            "x-ray",
            "xylophone",
            "yoga",
            "yogurt",
            "yoyo",
            "you",
            "year",
            "yummy",
            "zebra",
            "zigzag",
            "zoology",
            "zone",
            "zeal"
        )*/

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

    init {
        initializeGame()
    }

    fun initializeGame(){
        Log.d(TAG, "Initializing the game")
        val randomShuffledWord = pickRandomWordFromList()
        _gameUiState.value = _gameUiState.value.copy(
            currentScrambledWord = randomShuffledWord
        )
    }

    fun updateUserGuess(guessedWord: String){
        Log.d(TAG, "User has typed $guessedWord")
        userGuess = guessedWord
    }

    private fun updateGameState(updatedScore: Int) {
        if (usedWords.size == 10){
            //Last round in the game, update isGameOver to true, don't pick a new word
            _gameUiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        } else{
            // Normal round in the game
            _gameUiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = pickRandomWordFromList(),
                    currentWordCount = currentState.currentWordCount.inc(),
                    score = updatedScore
                )
            }
        }
        Log.d(TAG, "Updated Game ui state ${_gameUiState.value}")
    }


    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            // User's guess is correct, increase the score
            // and call updateGameState() to prepare the game for next round
            val updatedScore = _gameUiState.value.score.plus(20)
            updateGameState(updatedScore)
        } else {
            // User's guess is wrong, show an error
            _gameUiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        // Reset user guess
        updateUserGuess("")
    }

    /*
     * Skip to next word
     */
    fun skipWord() {
        updateGameState(_gameUiState.value.score)
        // Reset user guess
        updateUserGuess("")
    }



    fun shuffleCurrentWord( chosenWord : String) : String{
        ///Home -> omeH
        val wordsArray = chosenWord.toCharArray()
        wordsArray.shuffle()
        Log.d(TAG, "Shuffled word ${String(wordsArray)}")
        return String(wordsArray)
    }

    fun pickRandomWordFromList() : String{
        currentWord = allWords.random()
        return if(usedWords.contains(currentWord)){
           pickRandomWordFromList()
        }
        else{
            usedWords.add(currentWord)
            val shuffledWord = shuffleCurrentWord(currentWord)
            shuffledWord
        }
    }


}