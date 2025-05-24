package org.aziza.project.domain.repository

import org.aziza.project.domain.model.User


fun interface IMainRepository {
    suspend fun getUsers(): List<User>

}