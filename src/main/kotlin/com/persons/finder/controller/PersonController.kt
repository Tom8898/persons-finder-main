package com.persons.finder.controller

import com.persons.finder.domain.services.PersonsService
import com.persons.finder.controller.dto.CreatePersonRequest
import com.persons.finder.controller.dto.CreatePersonResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/persons")
class PersonController(private val personsService: PersonsService) {

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