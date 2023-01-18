package com.example.ch2.model

import org.springframework.data.annotation.Id
import java.awt.Point
import java.util.*

class Item(
    @Id
    var id: String? = null,
    var name: String,
    var price: Double
) {
    private lateinit var description: String
    private lateinit var distributorRegion: String
    private lateinit var releaseDate: Date
    private var availableUnits: Int = 0
    private lateinit var location: Point
    private var active: Boolean = false
}