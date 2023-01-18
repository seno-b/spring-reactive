package com.example.ch2.model


data class CartItem(
    val item: Item,
    var quantity: Int = 1,
) {

    fun increment() {
        quantity++
    }

}