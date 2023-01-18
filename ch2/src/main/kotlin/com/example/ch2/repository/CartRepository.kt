package com.example.ch2.repository

import com.example.ch2.model.Cart
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CartRepository: ReactiveCrudRepository<Cart, String> {
}