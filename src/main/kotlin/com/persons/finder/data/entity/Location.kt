package com.persons.finder.data.entity

import javax.persistence.*

@Entity
@Table(name = "locations")
data class Location(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val referenceId: Long = 0,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)
