package com.example.ch2.model

import org.springframework.data.annotation.Id

data class Cart(
    @Id
    val id: String,
    @Transient
    val cartItems: MutableList<CartItem> = mutableListOf()
) {

}