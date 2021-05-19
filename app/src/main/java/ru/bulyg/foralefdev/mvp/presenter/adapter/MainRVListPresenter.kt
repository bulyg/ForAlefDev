package ru.bulyg.foralefdev.mvp.presenter.adapter

import ru.bulyg.foralefdev.mvp.view.item.MainRVItemView

interface MainRVListPresenter {
    fun getCount(): Int
    fun bindView(view: MainRVItemView)
    fun openDetailScreen(pos: Int)
}