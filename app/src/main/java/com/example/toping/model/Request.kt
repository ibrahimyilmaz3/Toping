package com.example.toping.model

data class Request(val type: String, val tour: Tour2?, val trip: Trip?)

data class Tour2(
    val price: String,
    val name: String,
    val description: String,
    val date: String,
    val hour: String,
    val payment: String
)

data class Trip(
    val price: String,
    val start: String,
    val stop1: String,
    val stop2: String,
    val destination: String,
    val date: String,
    val hour: String,
    val payment: String
)