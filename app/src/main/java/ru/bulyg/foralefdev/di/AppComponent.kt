package ru.bulyg.foralefdev.di

import dagger.Component
import ru.bulyg.foralefdev.di.module.ApiModule
import ru.bulyg.foralefdev.di.module.AppModule
import ru.bulyg.foralefdev.di.module.CiceroneModule
import ru.bulyg.foralefdev.di.module.RepositoryModule
import ru.bulyg.foralefdev.mvp.presenter.DetailPresenter
import ru.bulyg.foralefdev.mvp.presenter.MainActPresenter
import ru.bulyg.foralefdev.mvp.presenter.MainFragPresenter
import ru.bulyg.foralefdev.ui.App
import ru.bulyg.foralefdev.ui.activity.MainActivity
import ru.bulyg.foralefdev.ui.fragment.DetailFragment
import ru.bulyg.foralefdev.ui.fragment.MainFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CiceroneModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {
    fun inject(app: App)
    fun inject(activity: MainActivity)
    fun inject(presenter: MainActPresenter)
    fun inject(fragment: MainFragment)
    fun inject(presenter: MainFragPresenter)
    fun inject(fragment: DetailFragment)
    fun inject(presenter: DetailPresenter)
}