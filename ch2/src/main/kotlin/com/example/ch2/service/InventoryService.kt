package com.example.ch2.service

import com.example.ch2.model.Item
import com.example.ch2.repository.ItemRepository
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.mongodb.core.FluentMongoOperations
import org.springframework.data.mongodb.core.query.Criteria.byExample
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class InventoryService(private val itemRepository: ItemRepository, private val fluentMongoOperations: FluentMongoOperations) {

    // example 예시
    fun searchByExample(name: String, description: String, useAnd: Boolean): Any {
        val item = Item(name, description, 0.0)

        val matcher: ExampleMatcher = when (useAnd) {
            true -> ExampleMatcher.matchingAll()
            else -> ExampleMatcher.matchingAny().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // 부분일치 검색
                .withIgnoreCase() // 대소문자구분 x
                .withIgnorePaths("price") // 기본적으로 null 필드 무시, primitive type 인 경우 명시적으로 ignore 시켜준다.
        }

        return itemRepository.findAll(Example.of(item, matcher))
    }

    fun searchByFluentExample(name: String, description: String, useAnd: Boolean): MutableList<Item> {
        val item = Item(name, description, 0.0)

        val matcher: ExampleMatcher = when (useAnd) {
            true -> ExampleMatcher.matchingAll()
            else -> ExampleMatcher.matchingAny().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // 부분일치 검색
                .withIgnoreCase() // 대소문자구분 x
                .withIgnorePaths("price") // 기본적으로 null 필드 무시, primitive type 인 경우 명시적으로 ignore 시켜준다.
        }

        return fluentMongoOperations.query(Item::class.java).matching(Query.query(byExample(Example.of(item, matcher))))
            .all()
    }
}