package com.example.ch2.controller

import com.example.ch2.model.Dish
import com.example.ch2.service.KitchenService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class ServerRestController(
    private val kitchenService: KitchenService
) {
    @GetMapping(value = ["/server"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun serveDishes(): Flux<Dish> {
        return this.kitchenService.getDishes()
    }

    @GetMapping(value = ["/served-dishes"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun deliverDishes(): Flux<Dish> {
        return this.kitchenService.getDishes().map { Dish.deliver(it) }
    }
}