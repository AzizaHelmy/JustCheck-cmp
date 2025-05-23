package org.aziza.project.data.source

import RandomUser
import RandomUserApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.aziza.project.getEngine

interface UserRemoteDataSource {
    suspend fun getUsers(): List<RandomUser>
    fun close()
}

class UserRemoteDataSourceImpl : UserRemoteDataSource {
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        explicitNulls = false
        coerceInputValues = true
    }

    private val client = HttpClient(getEngine()) {
        install(ContentNegotiation) {
            json(json)
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    println("HTTP Client: $message")
                }
            }
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 300_000
        }
        defaultRequest {
            header("Content-Type", "application/json")
            header("Accept-Language", "en")
            url("https://randomuser.me/api/")
        }
        install(DefaultRequest) {
            header(HttpHeaders.Accept, "application/json")
        }
    }

    override suspend fun getUsers(): List<RandomUser> {
        return try {
            val response = client.get("https://randomuser.me/api/?results=20")
            val apiResponse: RandomUserApiResponse = json.decodeFromString(response.bodyAsText())
            apiResponse.results
        } catch (e: Exception) {
            println("Network error: ${e.message}")
            emptyList()
        }
    }

    override fun close() {
        client.close()
    }
} 