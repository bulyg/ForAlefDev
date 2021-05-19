package ru.bulyg.foralefdev.ui

import android.app.Application
import ru.bulyg.foralefdev.di.AppComponent
import ru.bulyg.foralefdev.di.DaggerAppComponent

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .build()

        appComponent.inject(this)
    }
}