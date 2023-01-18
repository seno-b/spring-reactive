package com.example.ch2.model

data class Dish(
    val description: String,
    var delivered: Boolean = false
) {
    companion object {
        fun deliver(dish: Dish): Dish {
            val deliveredDish = Dish(dish.description)
            deliveredDish.delivered = true
            return deliveredDish
        }
    }
}