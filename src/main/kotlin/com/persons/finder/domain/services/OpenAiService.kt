package com.persons.finder.domain.services

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class OpenAiService(
    @Value("\${openai.api-key}") private val apiKey: String,
    @Value("\${openai.model:gpt-3.5-turbo}") private val model: String,
    private val restTemplate: RestTemplate
) : AiService {

    companion object {
        private const val API_URL = "https://api.openai.com/v1/chat/completions"
    }

    override fun generateBio(jobTitle: String, hobbies: String): String {
        val headers = HttpHeaders().apply {
            setBearerAuth(apiKey)
            contentType = MediaType.APPLICATION_JSON
        }
        val prompt = "Write a short, quirky, and fun bio (under 80 words) for someone who works as a $jobTitle and enjoys $hobbies."
        val body = ChatRequest(
            model = model,
            messages = listOf(ChatMessage(role = "user", content = prompt))
        )
        val response = restTemplate.exchange(
            API_URL, HttpMethod.POST, HttpEntity(body, headers), ChatResponse::class.java
        )
        return response.body?.choices?.firstOrNull()?.message?.content?.trim() ?: ""
    }

    data class ChatMessage(val role: String, val content: String)
    data class ChatRequest(val model: String, val messages: List<ChatMessage>, val max_tokens: Int = 150)
    data class ChatChoice(val message: ChatMessage)
    data class ChatResponse(val choices: List<ChatChoice>)
}