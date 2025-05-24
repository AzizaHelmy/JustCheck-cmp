package org.aziza.project.data.repository

import org.aziza.project.data.mapper.toEntity
import org.aziza.project.data.source.IMainDataSource
import org.aziza.project.domain.model.User
import org.aziza.project.domain.repository.IMainRepository


class MainRepository(private val remoteDataSource: IMainDataSource) : IMainRepository {

    override suspend fun getUsers(): List<User> {
        return remoteDataSource.getUsers().toEntity()
    }
} 