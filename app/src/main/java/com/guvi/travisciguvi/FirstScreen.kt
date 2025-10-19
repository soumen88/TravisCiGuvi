package com.guvi.travisciguvi

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen(){
    Log.d("FirstScreen", "Creating first screen")
    var sliderValue by remember { mutableStateOf(0.25f) }
    var clickCount by remember { mutableStateOf(0) }
    Scaffold(
        content = { paddingValues ->
            Log.d("FirstScreen", "Recomposing this screen")
            Column(
                modifier = Modifier.padding(paddingValues).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    "Counter ${clickCount}",
                        modifier = Modifier.testTag("clickText"),
                )
                Button(onClick = {
                    clickCount++
                },
                    modifier = Modifier.testTag("testButton")
                ) {
                    Text("Increment")
                }

                Box(
                    modifier = Modifier.height(30.dp)
                )

                Slider(
                    value = sliderValue,
                    onValueChange = {
                        Log.d("FirstScreen", "Value of slider $sliderValue")
                        sliderValue = it
                    }
                )
            }
        }
    )
}
