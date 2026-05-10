package com.persons.finder.domain.services

import com.persons.finder.data.entity.Location
import com.persons.finder.data.entity.Person
import com.persons.finder.data.repository.LocationRepository
import com.persons.finder.data.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonsServiceImpl(
    private val personRepository: PersonRepository,
    private val locationRepository: LocationRepository,
    private val aiService: AiService
) : PersonsService {

    override fun getById(id: Long): Person =
        personRepository.findById(id).orElseThrow { NoSuchElementException("Person $id not found") }

    override fun save(person: Person) {
        personRepository.save(person)
    }

    override fun create(name: String, title: String, hobbies: String, latitude: Double, longitude: Double): Long {
        val bio = aiService.generateBio(title, hobbies)
        val person = personRepository.save(Person(name = name, title = title, hobbies = hobbies, bio = bio))
        locationRepository.save(Location(referenceId = person.id, latitude = latitude, longitude = longitude))
        return person.id
    }
}