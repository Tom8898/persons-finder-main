package com.persons.finder.domain.services

interface AiService {
    fun generateBio(jobTitle: String, hobbies: String): String
}