package com.example.dodo_hw.model

import android.graphics.drawable.Drawable
import java.io.Serializable
import java.util.UUID

data class Pizza(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String,
    val image: Drawable?,
    val startPrice: Int
) : Serializable
