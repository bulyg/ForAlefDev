package ru.bulyg.foralefdev.mvp.presenter

import moxy.MvpPresenter
import ru.bulyg.foralefdev.mvp.view.DetailView

class DetailPresenter : MvpPresenter<DetailView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }
}