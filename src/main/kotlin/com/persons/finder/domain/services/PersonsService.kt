package com.persons.finder.domain.services

import com.persons.finder.data.entity.Person

interface PersonsService {
    fun getById(id: Long): Person
    fun save(person: Person)
    fun create(name: String, title: String, hobbies: String, latitude: Double, longitude: Double): Long
}