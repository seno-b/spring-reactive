package com.example.ch2.repository

import com.example.ch2.model.Item
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface ItemRepository: ReactiveCrudRepository<Item, String>, ReactiveQueryByExampleExecutor<Item> {
    // query method 방식
    fun findByNameContaining(partialName: String): Flux<Item>

    // 사용자 정의 query 방식
    @Query("{ 'name' :  ?0, 'price' :  ?1 }")
    fun findItemsForCustomerMonthlyReport(name: String, age: Double): Flux<Item>

    // 외않대?
//    @Query(sort = "{ name : -1 }")
//    fun findSortedStuffForWeeklyReport(): Flux<Item>
}