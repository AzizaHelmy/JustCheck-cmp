package org.aziza.project.data.source

import RandomUser
import RandomUserApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpRequestRetry
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
import io.ktor.utils.io.errors.IOException
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.aziza.project.getEngine

fun interface IMainDataSource {
    suspend fun getUsers(): List<RandomUser>
}

class MainDataSource : IMainDataSource {

    @OptIn(ExperimentalSerializationApi::class)
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
        install(HttpRequestRetry) {
            maxRetries = 3
            retryIf { _, response ->
                response.status.value >= 500
            }
            retryOnExceptionIf { _, cause ->
                cause is IOException || cause.message?.contains("The network connection was lost") == true
            }
            delayMillis { retry -> retry * 1000L }
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 15000
            connectTimeoutMillis = 10000
            socketTimeoutMillis = 15000
        }

        defaultRequest {
            header("Content-Type", "application/json")
            header("Accept-Language", "en")
            url("https://dummyjson.com/users")
        }
        install(DefaultRequest) {
            header(HttpHeaders.Accept, "application/json")
        }
    }

    override suspend fun getUsers(): List<RandomUser> {
        return try {
            val response = client.get("https://dummyjson.com/users")
            val apiResponse: RandomUserApiResponse = json.decodeFromString(response.bodyAsText())
            apiResponse.results
        } catch (e: Exception) {
            println("Network error: ${e.message}")
            emptyList()
        }
    }

    //todo: close
    fun close() {
        client.close()
    }
} 