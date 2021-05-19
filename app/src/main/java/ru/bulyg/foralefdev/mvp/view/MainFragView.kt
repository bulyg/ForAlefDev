package ru.bulyg.foralefdev.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface MainFragView : MvpView {
    fun init()
    fun update()

    @StateStrategyType(SkipStrategy::class)
    fun setRefreshing(isRefreshing: Boolean)
}