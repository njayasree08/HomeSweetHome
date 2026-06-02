package com.example.homesweethome

import java.io.Serializable

data class HomeProduct(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val longDescription: String,
    val imageRes: Int,
    val rating: Double
) : Serializable
