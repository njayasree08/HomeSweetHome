package com.example.homesweethome

import java.io.Serializable

data class FoodItem(
    val id: Int,
    val name: String,
    val restaurant: String,
    val price: Double,
    val description: String,
    val imageRes: Int,
    val rating: Double,
    val isDrink: Boolean = false,
    var addCheese: Boolean = false
) : Serializable
