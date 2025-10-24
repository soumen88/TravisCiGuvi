package com.guvi.travisciguvi.extensions

fun Int.isEven() : Boolean{
    val incomingNumber = this
    val isDivisibleByTwo = incomingNumber % 2 == 0
    return isDivisibleByTwo
}