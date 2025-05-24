package org.aziza.project.domain.usecase

import org.aziza.project.domain.repository.IMainRepository


class GetAllUsersUseCase(private val mainRepository: IMainRepository) {
    suspend operator fun invoke() = mainRepository.getUsers()
}