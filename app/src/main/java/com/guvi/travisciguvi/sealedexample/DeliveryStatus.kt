package com.guvi.travisciguvi.sealedexample

sealed class DeliveryStatus {
    object Preparing : DeliveryStatus()
    data class Dispatched(val trackingId : String) : DeliveryStatus()
    data class Delivered(val receiverName : String) : DeliveryStatus()

}