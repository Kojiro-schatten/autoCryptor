package com.example.backendkotlindevelopment
import java.time.LocalDateTime

/**
 * data model for web api
 *
 * this file is used to response
 * Controller: to respond
 * Service: req/res
 * Repository: req/res with DB
 *
 * @property id bigint
 * @property name string
 * @property createdAt timestamp
 * @property updatedAt timestamp
 */

data class User(
    val id: Long,
    val name: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)