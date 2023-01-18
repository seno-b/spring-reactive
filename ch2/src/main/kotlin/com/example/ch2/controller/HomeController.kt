package com.example.ch2.controller

import com.example.ch2.model.Cart
import com.example.ch2.model.CartItem
import com.example.ch2.repository.CartRepository
import com.example.ch2.repository.ItemRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.reactive.result.view.Rendering
import reactor.core.publisher.Mono


@Controller
class HomeController(
    private val itemRepository: ItemRepository,
    private val cartRepository: CartRepository,
) {

    @GetMapping("/home")
    fun home(): Mono<Rendering> {
        // 타임 리프도 리액티브 스트림 호환 템플릿 엔진이다.
        return Mono.just(
            Rendering.view("home.html")
                .modelAttribute("items", this.itemRepository.findAll())
                .modelAttribute(
                    "cart", this.cartRepository.findById("My Cart")
                        .defaultIfEmpty(Cart("My Cart"))
                ).build()
        )
    }

    @PostMapping("/add/{id}")
    fun addToCart(@PathVariable id: String): Mono<String> {
        val myCart = this.cartRepository.findById("My Cart")
            .defaultIfEmpty(Cart("My Cart"))

        return myCart.flatMap { cart ->
            cart.cartItems.stream()
                .filter { cartItem ->
                    cartItem.item.id.equals(id)
                }
                .findAny()
                .map { cartItem ->
                    cartItem.increment()
                    Mono.just(cart)
                }
                .orElseGet {
                    itemRepository.findById(id)
                        .map { CartItem(it) }
                        .map {
                            cart.cartItems.add(it)
                            cart
                        }
                }
        }.flatMap(cartRepository::save)
            .thenReturn("redirect:/home")
    }
}