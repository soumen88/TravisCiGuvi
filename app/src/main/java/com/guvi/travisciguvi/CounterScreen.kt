package com.guvi.travisciguvi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterScreen(counterViewModel: CounterViewModel = viewModel()){

    val counterValue by counterViewModel.uiCounter.collectAsState()

    Scaffold(
        topBar = {
            DisplayAppBar(
              appBarCaption = "Counter Screen $counterValue",
              onBackButtonPress = {

              }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Counter Value $counterValue",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                )
                Box(
                    modifier = Modifier.padding(20.dp)
                )
                CustomButton(
                    onButtonPress = {
                        counterViewModel.incrementCounter()
                    },
                    buttonCaption = "Increment"
                )
                CustomButton(
                    onButtonPress = {
                        counterViewModel.reset()
                    },
                    buttonCaption = "Reset"
                )
            }
        }
    )
}