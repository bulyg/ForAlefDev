package ru.bulyg.foralefdev.mvp.presenter

import moxy.MvpPresenter
import ru.bulyg.foralefdev.mvp.view.MainActView
import ru.bulyg.foralefdev.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainActPresenter : MvpPresenter<MainActView>() {
    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.MainScreen())
    }
}