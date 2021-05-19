package ru.bulyg.foralefdev.mvp.presenter

import moxy.MvpPresenter
import ru.bulyg.foralefdev.mvp.model.Model
import ru.bulyg.foralefdev.mvp.view.DetailView
import javax.inject.Inject

class DetailPresenter : MvpPresenter<DetailView>() {
    @Inject
    lateinit var model: Model

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init(model.url)
    }
}