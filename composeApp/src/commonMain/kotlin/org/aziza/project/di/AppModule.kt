package org.aziza.project.di

import org.aziza.project.data.repository.UserRepository
import org.aziza.project.data.repository.UserRepositoryImpl
import org.aziza.project.data.source.UserRemoteDataSource
import org.aziza.project.data.source.UserRemoteDataSourceImpl
import org.aziza.project.presentation.UserViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    // Data Source
    single<UserRemoteDataSource> { UserRemoteDataSourceImpl() }
    
    // Repository
    single<UserRepository> { UserRepositoryImpl(get()) }
    
    // ViewModel
    single { UserViewModel(get()) }
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
} 