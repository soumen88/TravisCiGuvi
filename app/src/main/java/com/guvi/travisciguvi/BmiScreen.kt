package com.guvi.travisciguvi

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

@Composable
fun BmiScreen(){
    val TAG = "BmiScreen"
    var userHeight = 0.0
    var userWeight = 0.0
    var userBmiValue by remember { mutableStateOf(0.0) }

    Scaffold(
        topBar = {
            DisplayAppBar(
                appBarCaption = "Bmi calculator Screen",
                onBackButtonPress = {

                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                DisplayInputField(
                    hintText = "Enter your weight (in kg)",
                    onValueChange = {
                        Log.d(TAG, "User has entered weight $it")
                        userWeight = it
                    }
                )
                Box(
                    modifier = Modifier.padding(12.dp)
                )
                DisplayInputField(
                    hintText = "Enter your height (in meters)",
                    onValueChange = {
                        Log.d(TAG, "User has entered height $it")
                        userHeight = it
                    }
                )
                CustomButton(
                    onButtonPress = {
                        Log.d(TAG, "Button was pressed")
                        val bmiValue = BmiCalculator().calculateBmi(weightInKg = userWeight, heightInMeters = userHeight)
                        Log.d(TAG, "BMI ${bmiValue.first}")
                        Log.d(TAG, "Weight Status ${bmiValue.second}")
                        userBmiValue = bmiValue.first
                    },
                    buttonCaption = "Calculate BMI"
                )

                if(userBmiValue != 0.0){
                    Text(
                        text = "User BMI value is $userBmiValue",
                        style = TextStyle(
                            fontSize = 22.sp,
                            color = Color.Black
                        )
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun TestBmiScreen(){
    BmiScreen()
}