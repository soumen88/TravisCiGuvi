package com.guvi.travisciguvi

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.guvi.travisciguvi.navigation.ScreenEnums
import com.guvi.travisciguvi.sealedexample.DeliveryStatus

@Composable
fun HomeScreen(navHostController: NavHostController){
    Scaffold(
        topBar = {
            DisplayAppBar(
                appBarCaption = "Home Screen",
                onBackButtonPress = {
                     navHostController.popBackStack(ScreenEnums.HomeScreen.name, inclusive = true)
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
                    text = "You are in home screen",
                    style = TextStyle(
                        fontSize = 24.sp
                    )
                )
                CustomButton(
                    onButtonPress = {
                        val statusOne = DeliveryStatus.Preparing
                        val statusTwo = DeliveryStatus.Dispatched("TRX12345")
                        val statusThree = DeliveryStatus.Delivered("John")
                        displayDeliveryStatus(statusOne)
                        displayDeliveryStatus(statusTwo)
                        displayDeliveryStatus(statusThree)
                    },
                    buttonCaption = "Understanding Sealed classes"

                )
                CustomButton(
                    onButtonPress = {
                        navHostController.navigateUp()
                    },
                    buttonCaption = stringResource(R.string.go_back)
                )
            }
        }
    )
}

fun displayDeliveryStatus(status : DeliveryStatus){
    when(status){
        is DeliveryStatus.Delivered -> {
            Log.d("HomeScreen", "Order has been delivered to ${status.receiverName}")

        }
        is DeliveryStatus.Dispatched -> {
            Log.d("HomeScreen", "Order has been dispatched with tracking id ${status.trackingId}")
        }
        is DeliveryStatus.Preparing -> {
            Log.d("HomeScreen", "Order has been prepared for delivery")
        }
    }
}

@Preview
@Composable
private fun DisplayHomeScreen(){
    //HomeScreen()
}