package com.persons.finder.presentation

import com.persons.finder.domain.services.PersonsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/persons")
class PersonController(private val personsService: PersonsService) {

    data class CreatePersonRequest(
        val name: String,
        val title: String,
        val hobbies: String,
        val latitude: Double,
        val longitude: Double
    )

    data class CreatePersonResponse(val id: Long)

    @PostMapping
    fun createPerson(@RequestBody request: CreatePersonRequest): ResponseEntity<CreatePersonResponse> {
        val id = personsService.create(
            name = request.name,
            title = request.title,
            hobbies = request.hobbies,
            latitude = request.latitude,
            longitude = request.longitude
        )
        return ResponseEntity.ok(CreatePersonResponse(id))
    }

    @GetMapping("")
    fun getExample(): String = "Hello Example"
}