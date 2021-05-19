package ru.bulyg.foralefdev.mvp.presenter

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import ru.bulyg.foralefdev.mvp.model.Model
import ru.bulyg.foralefdev.mvp.model.repository.ApiRepository
import ru.bulyg.foralefdev.mvp.presenter.adapter.MainRVListPresenter
import ru.bulyg.foralefdev.mvp.view.MainFragView
import ru.bulyg.foralefdev.mvp.view.item.MainRVItemView
import ru.bulyg.foralefdev.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainFragPresenter : MvpPresenter<MainFragView>() {
    @Inject
    lateinit var repository: ApiRepository

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var model: Model

    var listPresenter = ListPresenter()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        load()
    }

    inner class ListPresenter : MainRVListPresenter {
        var list = mutableListOf<String>()
        override fun getCount() = list.size

        override fun bindView(view: MainRVItemView) {
            view.setPicture(list[view.pos])
        }

        override fun openDetailScreen(pos: Int) {
            router.navigateTo(Screens.DetailScreen())
            model.url = list[pos]
        }
    }

    fun load() {
        viewState.setRefreshing(true)
        repository.getPictures().observeOn(AndroidSchedulers.mainThread()).subscribe({
            listPresenter.list.clear()
            listPresenter.list.addAll(it)
            viewState.setRefreshing(false)
            viewState.update()
        }, {
            viewState.setRefreshing(false)
        })


    }
}