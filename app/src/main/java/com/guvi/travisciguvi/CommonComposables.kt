package com.guvi.travisciguvi

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.guvi.travisciguvi.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayAppBar(
    appBarCaption : String,
    onBackButtonPress : () -> Unit
){
    TopAppBar(
        title = {
            Text(text = appBarCaption)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Purple40,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(
                onClick = {
                    onBackButtonPress()
                }
            ){
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun CustomButton(
    onButtonPress : () -> Unit,
    buttonCaption : String
){
    Button(
        onClick = {
            onButtonPress()
        }
    ) {
        Text(text = buttonCaption)
    }
}

@Composable
fun DisplayInputField(
    hintText : String,
    onValueChange : (Double) -> Unit
){
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        value = textFieldValue,
        onValueChange = {
            textFieldValue = it
            if(textFieldValue.text.isNotEmpty()){
                val userInputNumber = textFieldValue.text.toDouble()
                onValueChange(userInputNumber)
            }
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Color.Black,
            unfocusedTextColor = Color.Gray,
            errorContainerColor = Color.Red
        ),
        placeholder = {
            Text(text = hintText)
        }
    )
}

@Composable
fun DisplayInputTextField(
    hintText : String,
    onValueChange : (String) -> Unit
){
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        value = textFieldValue,
        onValueChange = {
            textFieldValue = it
            if(textFieldValue.text.isNotEmpty()){
                onValueChange(textFieldValue.text)
            }
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Color.Black,
            unfocusedTextColor = Color.Gray,
            errorContainerColor = Color.Red
        ),
        placeholder = {
            Text(text = hintText)
        }
    )
}

