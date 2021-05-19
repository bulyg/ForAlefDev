package ru.bulyg.foralefdev.ui.fragment

import kotlinx.android.synthetic.main.fragment_detail.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.bulyg.foralefdev.R
import ru.bulyg.foralefdev.mvp.presenter.DetailPresenter
import ru.bulyg.foralefdev.mvp.view.DetailView
import ru.bulyg.foralefdev.ui.App
import ru.bulyg.foralefdev.util.loadPictures

class DetailFragment(val url: String) : MvpAppCompatFragment(R.layout.fragment_detail), DetailView {
    companion object {
        fun newInstance(url: String) = DetailFragment(url)
    }

    @InjectPresenter
    lateinit var presenter: DetailPresenter

    @ProvidePresenter
    fun providePresenter() = DetailPresenter().apply {
        App.instance.appComponent.inject(this)
    }

    override fun init() {
        loadPictures(url, iv_detail)
    }
}