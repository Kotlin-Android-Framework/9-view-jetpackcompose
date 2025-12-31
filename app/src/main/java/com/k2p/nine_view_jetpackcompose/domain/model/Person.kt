package com.k2p.nine_view_jetpackcompose.model

import java.time.LocalDate
import java.time.LocalDateTime

data class Person(
    val idUser: Long,
    val name: String,
    val lastName: String,
    val dateOfBirth: LocalDate,
    val age: Int,
    val weight: Float,
    val alive: Boolean,
    val creationDate: LocalDateTime,
    val modificationDate: LocalDateTime
)