package org.aziza.project.di

import org.aziza.project.data.repository.MainRepository
import org.aziza.project.data.source.IMainDataSource
import org.aziza.project.data.source.MainDataSource
import org.aziza.project.domain.repository.IMainRepository
import org.aziza.project.domain.usecase.GetAllUsersUseCase
import org.aziza.project.presentation.screen.home.HomeViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    // Data Source
    single<IMainDataSource> { MainDataSource() }

    // Repository
    single<IMainRepository> { MainRepository(get()) }

    // Use Case
    single { GetAllUsersUseCase(get()) }

    // ViewModel
    single { HomeViewModel(get()) }
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
} 