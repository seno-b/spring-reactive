package com.example.ch2.service

import com.example.ch2.repository.CartRepository
import com.example.ch2.repository.ItemRepository
import org.springframework.stereotype.Service


@Service
class CartService(
    private val itemRepository: ItemRepository,
    private val cartRepository: CartRepository
) {
}