package ru.bulyg.foralefdev.ui.activity

import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.bulyg.foralefdev.R
import ru.bulyg.foralefdev.mvp.presenter.MainActPresenter
import ru.bulyg.foralefdev.mvp.view.MainActView
import ru.bulyg.foralefdev.ui.App
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainActView {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @InjectPresenter
    lateinit var presenter: MainActPresenter

    @ProvidePresenter
    fun providePresenter() = MainActPresenter().apply {
        App.instance.appComponent.inject(this)
    }

    val navigator = SupportAppNavigator(this, R.id.fragment_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.instance.appComponent.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun init() {

    }
}