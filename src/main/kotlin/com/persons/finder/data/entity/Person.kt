package com.persons.finder.data.entity

import javax.persistence.*

@Entity
@Table(name = "persons")
data class Person(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
    val title: String = "",
    val hobbies: String = "",
    val bio: String = ""
)
