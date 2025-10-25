package com.guvi.travisciguvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel : ViewModel() {
    private val _counter = MutableStateFlow(0)
    val uiCounter : StateFlow<Int> = _counter.asStateFlow()

    fun incrementCounter(){
        _counter.value = _counter.value + 1
    }

    fun reset(){
        _counter.value = 0
    }
}