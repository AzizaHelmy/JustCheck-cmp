package org.aziza.project.data.repository

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.aziza.project.data.model.User
import org.aziza.project.data.model.UserResponse

interface UserRepository {
    suspend fun getUsers(): List<User>
}

class UserRepositoryImpl : UserRepository {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }

    override suspend fun getUsers(): List<User> {
        val response: UserResponse = client.get("https://randomuser.me/api/").body()
        return response.results
    }
} 