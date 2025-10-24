package com.guvi.travisciguvi

import kotlin.math.pow

class BmiCalculator {

    fun calculateBmi(weightInKg : Double, heightInMeters : Double) : Pair<Double, BmiEnum>{
        val bmiCalculatedValue = (weightInKg) / (heightInMeters.pow(2))

        val bmiEnumSelected = if(bmiCalculatedValue <= 18.5){
            BmiEnum.UNDER_WEIGHT
        }
        else if(bmiCalculatedValue > 18.5 && bmiCalculatedValue <= 25.0){

            BmiEnum.NORMAL_WEIGHT
        }
        else if(bmiCalculatedValue > 25 && bmiCalculatedValue <= 30){
            BmiEnum.OVER_WEIGHT
        }
        else{
            BmiEnum.OBESE
        }

        val returnValue = Pair(bmiCalculatedValue, bmiEnumSelected)
        return returnValue
    }
}