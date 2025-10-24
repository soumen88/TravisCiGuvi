package com.guvi.travisciguvi

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.guvi.travisciguvi.navigation.ScreenEnums
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHostController: NavHostController){

    val animationAlpha = remember {
        Animatable(1f)
    }

    LaunchedEffect(Unit) {
        while (true){
            animationAlpha.animateTo(
                targetValue = 1.0f,
                tween(durationMillis = 500)
            )
            delay(1000)
            animationAlpha.animateTo(
                targetValue = 0.0f,
                tween(durationMillis = 500)
            )
            delay(1000)
        }
    }

    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Welcome to our app",
                    style = TextStyle(
                        fontSize = 20.sp
                    ),
                    modifier = Modifier.alpha(animationAlpha.value)
                )
                Image(
                    painter = painterResource(id = R.drawable.travis_logo),
                    //contentDescription = null
                    contentDescription = stringResource(R.string.app_logo)
                )
                Box(
                    modifier = Modifier.padding(30.dp)
                )
                CustomButton(
                    onButtonPress = {
                        navHostController.navigate(ScreenEnums.HomeScreen.name)
                    },
                    buttonCaption = stringResource(R.string.get_started)
                )
            }
        }
    )
}

@Preview
@Composable
fun DisplaySplashScreen(){

}