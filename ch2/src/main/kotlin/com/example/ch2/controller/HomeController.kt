package com.example.ch2.controller

import com.example.ch2.model.Cart
import com.example.ch2.model.CartItem
import com.example.ch2.model.Item
import com.example.ch2.repository.CartRepository
import com.example.ch2.repository.ItemRepository
import com.example.ch2.service.CartService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.result.view.Rendering
import reactor.core.publisher.Mono


@Controller
class HomeController(
    private val itemRepository: ItemRepository,
    private val cartRepository: CartRepository,
    private val cartService: CartService
) {

}