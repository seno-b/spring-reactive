package com.example.ch2.service

import com.example.ch2.model.Dish
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.Duration
import java.util.*


@Service
class KitchenService {

    private var picker = Random()

    private fun randomDish(): Dish {
        return menu[picker.nextInt(menu.size)]
    }

    private val menu = listOf(Dish("Sesame chicken"), Dish("Lo mein noodles, plain"), Dish("Sweet & sour beef"))

    fun getDishes(): Flux<Dish> {
        return Flux.generate<Dish> { sink -> sink.next(randomDish()) }
            .delayElements(Duration.ofMillis(3000))
    }
}