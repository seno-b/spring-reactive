package com.example.ch2.model

import org.springframework.data.annotation.Id
import java.util.*

data class Item constructor(
    @Id
    val id: String,
    val name: String,
    val price: Double
) {
    private val description: String? = null
    private val distributorRegion: String? = null
    private val releaseDate: Date? = null
    private val availableUnits = 0
    private val active = false
}