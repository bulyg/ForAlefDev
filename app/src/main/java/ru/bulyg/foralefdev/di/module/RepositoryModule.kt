package ru.bulyg.foralefdev.di.module

import dagger.Module
import dagger.Provides
import ru.bulyg.foralefdev.mvp.model.api.ApiService
import ru.bulyg.foralefdev.mvp.model.repository.ApiRepository
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(apiService: ApiService): ApiRepository {
        return ApiRepository(apiService)
    }
}