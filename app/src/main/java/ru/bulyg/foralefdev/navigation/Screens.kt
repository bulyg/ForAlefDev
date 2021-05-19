package ru.bulyg.foralefdev.navigation

import ru.bulyg.foralefdev.ui.fragment.DetailFragment
import ru.bulyg.foralefdev.ui.fragment.MainFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class MainScreen() : SupportAppScreen() {
        override fun getFragment() = MainFragment.newInstance()
    }

    class DetailScreen(val url: String) : SupportAppScreen() {
        override fun getFragment() = DetailFragment.newInstance(url)
    }
}