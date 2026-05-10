package com.persons.finder.controller.dto

data class CreatePersonRequest(
    val name: String,
    val title: String,
    val hobbies: String,
    val latitude: Double,
    val longitude: Double
)

data class CreatePersonResponse(val id: Long)