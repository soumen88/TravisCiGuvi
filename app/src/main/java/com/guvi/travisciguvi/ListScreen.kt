package com.guvi.travisciguvi

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun  ListScreen(itemsInList : MutableList<String>){
    var validationMessage by remember { mutableStateOf("") }
    Scaffold(
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                LazyColumn {
                    items(itemsInList.size) { index ->
                        val individualItems = itemsInList[index]
                        Text(
                            text = individualItems,
                            style = TextStyle(
                                fontSize = 18.sp
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                                .clickable {
                                    if (individualItems == "Item 3"){
                                        validationMessage = "Yes item 3 is visible"
                                    }
                                }
                        )
                    }
                }
                if(validationMessage.isNotEmpty()){
                    Text(
                        "Item found",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.Red
                        )
                    )
                }

            }
        }
    )
}