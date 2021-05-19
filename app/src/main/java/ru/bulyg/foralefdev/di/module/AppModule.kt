package ru.bulyg.foralefdev.di.module

import dagger.Module
import dagger.Provides
import ru.bulyg.foralefdev.ui.App

@Module
class AppModule(val app: App) {
    @Provides
    fun app(): App {
        return app
    }
}