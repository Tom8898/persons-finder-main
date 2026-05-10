package com.persons.finder.data.repository

import com.persons.finder.data.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long>