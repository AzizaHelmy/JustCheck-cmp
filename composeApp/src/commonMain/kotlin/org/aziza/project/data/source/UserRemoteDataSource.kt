package org.aziza.project.data.source

import RandomUser
import RandomUserApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

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

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(json)
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 30_000
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