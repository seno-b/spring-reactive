package com.example.ch2.repository

import com.example.ch2.model.Item
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface ItemRepository: ReactiveCrudRepository<Item, String> {
    fun findByNameContaining(partialName: String): Flux<Item>
}