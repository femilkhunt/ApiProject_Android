package com.example.newtry

import android.media.Rating

data class RetroFitData(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)