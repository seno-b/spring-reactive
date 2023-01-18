package com.example.ch2.repository

import com.example.ch2.model.Item
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ItemRepository: ReactiveCrudRepository<Item, String> {
}