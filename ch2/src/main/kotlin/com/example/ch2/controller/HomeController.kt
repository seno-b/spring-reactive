package com.example.ch2.controller

import com.example.ch2.repository.CartRepository
import com.example.ch2.repository.ItemRepository
import com.example.ch2.service.CartService
import org.springframework.stereotype.Controller


@Controller
class HomeController(
    private val itemRepository: ItemRepository,
    private val cartRepository: CartRepository,
    private val cartService: CartService
) {

}