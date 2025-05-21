package org.aziza.project.data.repository

import RandomUser
import org.aziza.project.data.source.UserRemoteDataSource

interface UserRepository {
    suspend fun getUsers(): List<RandomUser>
    fun close()
}

class UserRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {
    override suspend fun getUsers(): List<RandomUser> {
        return remoteDataSource.getUsers()
    }

    override fun close() {
        remoteDataSource.close()
    }
} 